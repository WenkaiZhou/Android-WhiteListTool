    {
        "items": [
            {   
                "desc": "华为手机白名单管理",
                "device": {
                    "brand": "Huawei"
                },
                "intents": [
                    {
                        "desc": "开机自动启动",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许自动启动。",
                        "action": "huawei.intent.action.HSM_BOOTAPP_MANAGER"
                    },
                    {
                        "desc": "锁屏清理",
                        "title": "需要加入锁屏清理白名单",
                        "message": "为了核心服务的正常运行，需要加入锁屏清理白名单。",
                        "action": "huawei.intent.action.HSM_PROTECTED_APPS"
                    }
                ]
            },
            {
                "desc": "小米手机白名单管理",
                "device": {
                    "brand": "Xiaomi"
                },
                "intents": [
                    {
                        "desc": "开机自动启动",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许自动启动。",
                        "action": "miui.intent.action.OP_AUTO_START",
                        "categories": [
                            "android.intent.category.DEFAULT"
                        ]
                    },
                    {
                        "desc": "神隐模式",
                        "title": "需要关闭神隐模式",
                        "message": "为了核心服务的正常运行，需要关闭神隐模式。",
                        "component": {
                            "pkg": "com.miui.powerkeeper",
                            "cls": "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"
                        },
                        "extras": [
                            {
                                "key": "package_name",
                                "value": "com.kevin.whitelisttool"
                            },
                            {
                                "key": "package_label",
                                "value": "Android-WhiteListTool"
                            }
                        ]
                    }
                ]
            },
            {
                "desc": "OPPO手机白名单管理",
                "device": {
                    "brand": "OPPO"
                },
                "intents": [
                    {
                        "desc": "开机自动启动 // OPPO R15 OPPO R17",
                        "title": "需要允许自动启动 1",
                        "message": "为了核心服务的正常运行，需要在权限管理的自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.coloros.safecenter",
                            "cls": "com.coloros.privacypermissionsentry.PermissionTopActivity"
                        }
                    },
                    {
                        "desc": "开机自动启动 // OPPO R9",
                        "title": "需要允许自动启动 2",
                        "message": "为了核心服务的正常运行，需要在权限管理的自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.coloros.safecenter",
                            "cls": "com.coloros.safecenter.permission.PermissionTopActivity"
                        }
                    },
                    {
                        "desc": "开机自动启动 // OPPO R7",
                        "title": "需要允许自动启动 3",
                        "message": "为了核心服务的正常运行，需要在权限管理的自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.color.safecenter",
                            "cls": "com.color.safecenter.permission.PermissionTopActivity"
                        }
                    }
                ]
            },
            {
                "desc": "VIVO手机白名单管理",
                "device": {
                    "brand": "vivo"
                },
                "intents": [
                   {
                        "desc": "后台高耗电",
                        "title": "需要允许后台高耗电",
                        "message": "为了核心服务的正常运行，需要添加至允许后台高耗电。",
                        "component": {
                            "pkg": "com.vivo.abe",
                            "cls": "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"
                        }
                    }
                ]
            },
            {
                "desc": "三星手机白名单管理",
                "device": {
                    "brand": "samsung"
                },
                "intents": [
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动 1",
                        "message": "为了核心服务的正常运行，需要允许自动启动。",
                        "component": {
                            "pkg": "com.samsung.android.sm",
                            "cls": "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity"
                        }
                    },
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动 2",
                        "message": "为了核心服务的正常运行，需要允许自动启动。",
                        "component": {
                            "pkg": "com.samsung.android.sm_cn",
                            "cls": "com.samsung.android.sm.ui.battery.BatteryActivity"
                        }
                    }
                ]
            },
            {
                "desc": "Letv手机白名单管理",
                "device": {
                    "brand": "Letv"
                },
                "intents": [
                    {
                        "desc": "乐视自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加至白名单。",
                        "action": "com.letv.android.permissionautoboot"
                    },
                    {
                        "desc": "乐视应用保护",
                        "title": "需要添加至应用保护",
                        "message": "为了核心服务的正常运行，需要添加至应用保护。",
                        "component": {
                            "pkg": "com.letv.android.letvsafe",
                            "cls": "com.letv.android.letvsafe.BackgroundAppManageActivity"
                        }
                    }
                ]
            },
            {
                "desc": "魅族手机白名单管理",
                "device": {
                    "brand": "Meizu"
                },
                "intents": [
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要自启动。",
                        "component": {
                            "pkg": "com.meizu.safe",
                            "cls": "com.meizu.safe.security.HomeActivity"
                        }
                    }
                ]
            },
            {
                "desc": "一加手机白名单管理",
                "device": {
                    "brand": "ONEPLUS"
                },
                "intents": [
                    {
                        "desc": "一加自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加至白名单。",
                        "component": {
                            "pkg": "com.oneplus.security",
                            "cls": "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"
                        }
                    }
                ]
            },
            {
                "desc": "锤子手机白名单管理",
                "device": {
                    "brand": "SMARTISAN"
                },
                "intents": [
                    {
                        "desc": "锤子自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加至自启动管理。",
                        "component": {
                            "pkg": "com.smartisanos.security",
                            "cls": "com.smartisanos.security.invokeHistory.InvokeHistoryActivity"
                        },
                        "extras": [
                            {
                                "key": "packageName",
                                "value": "com.kevin.whitelisttool"
                            }
                        ]
                    }
                ]
            }
        ]
    }
                    