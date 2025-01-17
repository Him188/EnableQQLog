package test


fun isIgnored(s: String?): Boolean = s == null || IgnoredPackets.contains(s) || IgnoredPacketFilters.any { it.invoke(s) }

internal val IgnoredPacketFilters: Array<(String) -> Boolean> = arrayOf(
    { it.contains("qzone", ignoreCase = true) }
)

@Suppress("SpellCheckingInspection")
internal val IgnoredPackets = arrayOf(
    "",
    "socketnetflow",
    "CliLogSvc.UploadReq",
    "QQService.CliLogSvc.MainServantObj",
    "QQService.ConfigPushSvc.MainServant",
    "KQQ.ConfigService.ConfigServantObj",
    "App_reportRDM",
    "RedTouchSvc.ClientReport",
    "MobileReport.UserActionReport",
    "JsApiSvr.webview.whitelist",
    "ConfigServantObj",
    "cmd_getServerConfig",
    "cmd_RegisterMsfService",
    "CameraModuleSvc",
    "Pay",
    "Game",
    "TianShu.GetAds",
    "MqqSafeDataRpt.MQDun",
    "ResourceConfig.ClientReqV2",
    "ResourceConfig.ClientReq",
    "ConfigurationService.ReqGetConfig",
    "apollo_game_login",
    "QQClubComm.getNewFlag",

    "OidbSvc.0xc42", // 似乎是上传点什么设备信息, 08 C2 18 10 00 22 FF 06 08 DD F1 92 B7 07 10 04 18 04 20 03 30 00 38 00 5A EC 06 08 08 1A 0F 08 01 12 08 44 54 48 61 73 52 65 64 1A 01 31 1A 10 08 00 12 09 55 6E 72 65 61 64 4D 73 67 1A 01 30 1A 13 08 64 12 0C 46 6F 6C 64 65 72 53 74 61 74 75 73 1A 01 30 1A 11 08 65 12 0A 4B 44 49 6E 53 63 72 65 65 6E 1A 01 30 1A A2 01 08 66 12 07 4B 44 41 74 74 72 4C 1A 94 01 7A 5A 54 58 30 74 58 5A 30 74 4F 55 6A 4A 53 55 6D 70 54 53 30 38 44 66 31 64 50 31 32 64 4C 54 6C 49 79 55 6A 6F 43 44 68 34 43 41 68 6F 53 45 6A 6F 36 47 68 6F 36 44 6C 4A 71 55 32 39 66 56 39 39 4C 53 78 4E 50 46 78 5A 53 4D 6C 49 61 47 6A 49 36 48 6A 49 54 54 6A 49 53 4F 6A 49 57 4F 6A 4E 44 54 6C 4A 71 55 31 39 6A 53 78 4E 6E 66 30 75 6E 66 30 70 53 4D 6C 49 50 55 67 64 53 45 67 34 4B 47 30 49 2B 50 30 4E 4F 48 67 59 53 55 79 77 3D 3D 1A 1C 08 6A 12 13 4C 61 73 74 52 65 64 45 78 70 6F 73 75 72 65 54 69 6D 65 1A 03 30 3A 30 1A 0D 08 6B 12 06 64 74 5F 72 65 64 1A 01 31 1A 26 08 6C 12 16 6C 61 73 74 5F 69 6E 66 6F 72 65 67 72 6F 75 6E 64 5F 74 69 6D 65 1A 0A 31 36 31 31 33 33 34 36 33 34 1A 20 08 6D 12 10 6C 61 73 74 5F 69 6E 5F 61 69 6F 5F 74 69 6D 65 1A 0A 31 36 31 31 33 33 34 34 38 34 1A 18 08 70 12 11 55 6E 69 76 65 72 73 61 6C 53 74 61 74 65 42 69 74 1A 01 30 1A 13 08 74 12 08 77 69 66 69 4E 61 6D 65 1A 05 38 32 45 46 45 1A 19 08 75 12 12 64 61 69 6C 79 5F 66 6F 6C 64 65 72 73 74 61 74 75 73 1A 01 31 1A 18 08 76 12 10 64 61 69 6C 79 5F 6D 73 67 62 6F 78 5F 70 6F 73 1A 02 2D 31 1A 16 08 77 12 0F 64 61 69 6C 79 5F 69 6E 5F 73 63 72 65 65 6E 1A 01 30 1A 13 08 78 12 0C 50 75 73 68 50 72 65 76 69 65 77 51 1A 01 31 1A 17 08 79 12 10 4E 6F 44 69 73 74 75 72 62 41 74 4E 69 67 68 74 1A 01 30 1A 1C 08 7B 12 05 42 53 53 49 44 1A 11 30 30 3A 38 31 3A 66 65 3A 32 38 3A 64 62 3A 33 38 1A 20 08 7C 12 19 4D 73 67 4C 69 73 74 46 72 69 73 74 44 61 74 61 49 73 56 69 73 61 62 6C 65 1A 01 31 1A 13 08 7E 12 0A 53 63 72 65 65 6E 49 6E 66 6F 1A 03 31 34 3A 1A 14 08 80 01 12 0C 69 73 5F 6A 63 6A 6A 5F 6D 6F 64 65 1A 01 30 1A 0F 08 81 01 12 07 6E 65 74 77 6F 72 6B 1A 01 34 1A 11 08 82 01 12 07 62 61 74 74 65 72 79 1A 03 31 30 30 1A 1A 08 83 01 12 09 73 65 73 73 69 6F 6E 49 44 1A 0A 31 36 31 31 33 33 34 31 35 31 1A 12 08 84 01 12 06 72 65 64 44 6F 74 1A 05 30 5F 31 5F 31 1A 3E 08 85 01 12 10 61 70 70 5F 69 6E 73 74 61 6C 6C 5F 6C 69 73 74 1A 27 77 73 5F 30 5F 2D 31 7C 6B 62 5F 30 5F 2D 31 7C 6C 6C 5F 30 5F 2D 31 7C 73 70 5F 30 5F 2D 31 7C 78 77 5F 30 5F 2D 31 1A 15 08 86 01 12 0D 69 73 5F 73 74 75 64 79 5F 6D 6F 64 65 1A 01 30 1A 13 08 87 01 12 0B 6B 64 54 61 62 4E 75 6D 52 65 64 1A 01 30 1A 2C 08 88 01 12 0D 34 54 61 62 52 65 64 53 74 61 74 75 73 1A 18 37 30 3A 30 5F 34 31 36 35 35 3A 30 5F 30 3A 30 5F 34 31 37 32 36 3A 30 32 0D 61 6E 64 72 6F 69 64 20 38 2E 35 2E 30
    "LightAppSvc.mini_app_report_transfer.DataReport",
    "OidbSvc.0x5eb_99", // recommendEmotionInfo

    "friendlist.getTroopMemberList",

    "OnlinePush.PbPushGroupMsg",
    "LightAppSvc.mini_app_userapp.GetDropdownAppList",

    "SSO.LoginMerge",
    "scupdate.handle",
)


// SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList