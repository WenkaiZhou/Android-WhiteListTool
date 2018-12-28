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
                        "message": "为了核心服务的正常运行，需要允许{label}的开机自启动。",
                        "action": "huawei.intent.action.HSM_BOOTAPP_MANAGER"
                    },
                    {
                        "desc": "锁屏清理",
                        "title": "需要加入锁屏清理白名单",
                        "message": "为了核心服务的正常运行，需要将{label}设置为受保护应用。",
                        "action": "huawei.intent.action.HSM_PROTECTED_APPS"
                    }
                ]
            },
            {   
                "desc": "华为手机白名单管理",
                "device": {
                    "brand": "Honor"
                },
                "intents": [
                    {
                        "desc": "开机自动启动",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许{label}的开机自启动。",
                        "action": "huawei.intent.action.HSM_BOOTAPP_MANAGER"
                    },
                    {
                        "desc": "锁屏清理",
                        "title": "需要加入锁屏清理白名单",
                        "message": "为了核心服务的正常运行，需要将{label}设置为受保护应用。",
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
                        "message": "为了核心服务的正常运行，需要在自启动管理中允许{label}自启动。",
                        "action": "miui.intent.action.OP_AUTO_START",
                        "categories": [
                            "android.intent.category.DEFAULT"
                        ]
                    },
                    {
                        "desc": "神隐模式",
                        "title": "需要关闭神隐模式",
                        "message": "为了核心服务的正常运行，需要在神隐模式中更改{label}为无限制。",
                        "component": {
                            "pkg": "com.miui.powerkeeper",
                            "cls": "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"
                        },
                        "extras": [
                            {
                                "key": "package_name",
                                "value": "{package}"
                            },
                            {
                                "key": "package_label",
                                "value": "{label}"
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
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要将{label}在自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.coloros.safecenter",
                            "cls": "com.coloros.privacypermissionsentry.PermissionTopActivity"
                        }
                    },
                    {
                        "desc": "开机自动启动 // OPPO R9",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要将{label}在自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.coloros.safecenter",
                            "cls": "com.coloros.safecenter.permission.PermissionTopActivity"
                        }
                    },
                    {
                        "desc": "开机自动启动 // OPPO R7",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要将{label}在自启动管理中添加为允许自动启动。",
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
                        "message": "为了核心服务的正常运行，需要添加{label}至允许后台高耗电。",
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
                        "desc": "自启动管理 5.0/5.1",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许{label}自动启动。",
                        "component": {
                            "pkg": "com.samsung.android.sm",
                            "cls": "com.samsung.android.sm.ui.battery.BatteryActivity"
                        }
                    },
                    {
                        "desc": "自启动管理 6.0",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许{label}自动启动。",
                        "component": {
                            "pkg": "com.samsung.android.sm_cn",
                            "cls": "com.samsung.android.sm.ui.battery.BatteryActivity"
                        }
                    },
                    {
                        "desc": "自启动管理 7.0/8.0",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要允许{label}自动启动。",
                        "component": {
                            "pkg": "com.samsung.android.lool",
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
                        "message": "为了核心服务的正常运行，需要添加{label}至白名单。",
                        "action": "com.letv.android.permissionautoboot"
                    },
                    {
                        "desc": "乐视应用保护",
                        "title": "需要添加至应用保护",
                        "message": "为了核心服务的正常运行，需要添加{label}至应用保护。",
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
                        "message": "为了核心服务的正常运行，需要{label}自启动。",
                        "component": {
                            "pkg": "com.meizu.safe",
                            "cls": "com.meizu.safe.security.AppSecActivity"
                        }
                    },
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要{label}自启动。",
                        "action": "com.meizu.safe.PERMISSION_SETTING"
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
                        "message": "为了核心服务的正常运行，需要添加{label}至自启动管理。",
                        "component": {
                            "pkg": "com.smartisanos.security",
                            "cls": "com.smartisanos.security.invokeHistory.InvokeHistoryActivity"
                        },
                        "extras": [
                            {
                                "key": "packageName",
                                "value": "{package}"
                            }
                        ]
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
                        "desc": "自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加{label}至自启动管理。",
                        "component": {
                            "pkg": "com.oneplus.security",
                            "cls": "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"
                        },
                        "extras": [
                            {
                                "key": "packageName",
                                "value": "{package}"
                            }
                        ]
                    }
                ]
            },
            {
                "desc": "HTC手机白名单管理",
                "device": {
                    "brand": "HTC"
                },
                "intents": [
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加{label}至自启动管理。",
                        "component": {
                            "pkg": "com.htc.pitroad",
                            "cls": "com.htc.pitroad.landingpage.activity.LandingPageActivity"
                        }
                    }
                ]
            },
            {
                "desc": "诺基亚手机白名单管理",
                "device": {
                    "brand": "Nokia"
                },
                "intents": [
                    {
                        "desc": "自启动管理",
                        "title": "需要允许自动启动",
                        "message": "为了核心服务的正常运行，需要添加{label}至自启动管理。",
                        "component": {
                            "pkg": "com.android.settings",
                            "cls": "com.android.settings.applications.InstalledAppDetails"
                        },
                        "extras": [
                            {
                                "key": "package",
                                "value": "{package}"
                            }
                        ]
                    }
                ]
            }
        ]
    }
                    