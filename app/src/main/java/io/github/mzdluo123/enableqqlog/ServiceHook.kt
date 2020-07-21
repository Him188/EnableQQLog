package io.github.mzdluo123.enableqqlog


import android.os.Parcel
import com.google.gson.Gson
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class ServiceHook : IXposedHookLoadPackage {
    private val gson = Gson()
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        val serviceClass =
            lpparam.classLoader.loadClass("com.tencent.qphone.base.remote.ToServiceMsg")


        XposedHelpers.findAndHookMethod(
            serviceClass,
            "writeToParcel",
            Parcel::class.java,
            Int::class.java,
            object : XC_MethodHook() {
                override fun afterHookedMethod(param: MethodHookParam) {
                    val data = gson.toJson(param.thisObject)
                    l("Svc-> $data")
                    LogUpload.upload(LogUpload.Companion.DIRECTION.OUT, "Svc", param.thisObject)
                }
            })

        val decodeHook = object : XC_MethodHook() {
            override fun afterHookedMethod(param: MethodHookParam) {
                val data = gson.toJson(param.thisObject)
                l("Svc<- $data")
                LogUpload.upload(LogUpload.Companion.DIRECTION.IN, "Svc", param.thisObject)
            }
        }
        val readMethod = serviceClass.getDeclaredMethod("readFromParcel", Parcel::class.java)
        readMethod.isAccessible = true
        XposedBridge.hookMethod(readMethod, decodeHook)

        l("hook ServiceMsg成功")
    }

}