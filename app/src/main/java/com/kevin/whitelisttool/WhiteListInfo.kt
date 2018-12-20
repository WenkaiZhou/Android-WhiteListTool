package com.kevin.whitelisttool

/**
 * WhiteListInfo
 *
 * @author zwenkai@foxmail.com, Created on 2018-12-19 19:27:32
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
class WhiteListInfo {
    var items: MutableList<WhiteList>? = null

    class WhiteList {
        var desc = ""
        var device: DeviceInfo? = null
        var intents: MutableList<IntentItem>? = null
    }


    class DeviceInfo {
        // 品牌
        var brand = ""
    }

    class IntentItem {
        var desc = ""
        var title = ""
        var message = ""
        var action = ""
        var categories: MutableList<String>? = null
        var component: Component? = null
        var extras: MutableList<Extra>? = null
    }

    class Component {
        // 包名
        var pkg = ""
        // class 名称
        var cls = ""
    }

    class Extra {
        var key = ""
        var value = ""
    }
}