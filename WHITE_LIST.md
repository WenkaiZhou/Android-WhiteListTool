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
                        "component": {
                            "pkg": "com.huawei.systemmanager",
                            "cls": "com.huawei.systemmanager.optimize.process.ProtectActivity"
                        }
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
                        "desc": "开机自动启动 // 8.0",
                        "title": "需要允许自动启动 1",
                        "message": "为了核心服务的正常运行，需要在权限管理的自启动管理中添加为允许自动启动。",
                        "component": {
                            "pkg": "com.coloros.safecenter",
                            "cls": "com.coloros.privacypermissionsentry.PermissionTopActivity"
                        }
                    },
                    {
                        "desc": "开机自动启动 // 7.0",
                        "title": "需要允许自动启动 2",
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
                        "message": "为了核心服务的正常运行，需要自动清理。",
                        "component": {
                            "pkg": "com.letv.android.letvsafe",
                            "cls": "com.letv.android.letvsafe.BackgroundAppManageActivity"
                        }
                    }
                ]
            }
        ]
    }
                    