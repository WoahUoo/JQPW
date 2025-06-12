const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-pay",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "售票员",
                    "menuJump": "列表",
                    "tableName": "shoupiaoyuan"
                }], "menu": "售票员管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "门票类型",
                    "menuJump": "列表",
                    "tableName": "menpiaoleixing"
                }], "menu": "门票类型管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "售票"],
                    "appFrontIcon": "cuIcon-vipcard",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "门票信息",
                    "menuJump": "列表",
                    "tableName": "menpiaoxinxi"
                }], "menu": "门票信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "退票","类型统计","售票员销售统计"],
                    "appFrontIcon": "cuIcon-medal",
                    "buttons": ["查看", "修改", "删除","类型统计","售票员销售统计"],
                    "menu": "售票订单",
                    "menuJump": "列表",
                    "tableName": "shoupiaodingdan"
                }], "menu": "售票订单管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "退票信息",
                    "menuJump": "列表",
                    "tableName": "tuipiaoxinxi"
                }], "menu": "退票信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "公告信息分类",
                    "tableName": "newstype"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "公告信息",
                    "tableName": "news"
                }], "menu": "公告信息管理"
            }],
            "frontMenu": [],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "售票"],
                    "appFrontIcon": "cuIcon-vipcard",
                    "buttons": ["售票", "查看"],
                    "menu": "门票信息",
                    "menuJump": "列表",
                    "tableName": "menpiaoxinxi"
                }], "menu": "门票信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "退票"],
                    "appFrontIcon": "cuIcon-medal",
                    "buttons": ["查看", "支付", "退票"],
                    "menu": "售票订单",
                    "menuJump": "列表",
                    "tableName": "shoupiaodingdan"
                }], "menu": "售票订单管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看"],
                    "menu": "退票信息",
                    "menuJump": "列表",
                    "tableName": "tuipiaoxinxi"
                }], "menu": "退票信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["查看"],
                    "menu": "公告信息",
                    "tableName": "news"
                }], "menu": "公告信息管理"
            }],
            "frontMenu": [],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "售票员",
            "tableName": "shoupiaoyuan"
        }]
    }
}
export default menu;
