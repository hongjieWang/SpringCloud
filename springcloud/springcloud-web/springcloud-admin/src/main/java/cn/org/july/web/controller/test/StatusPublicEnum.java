package cn.org.july.web.controller.test;

import cn.org.july.web.common.json.JSONObject;

public enum StatusPublicEnum {
    FAIL("失败", "300", "认证系统"),
    OK("成功", "200", "认证系统");

    private final String msg;
    private final String status;
    private final String code;

    StatusPublicEnum(String msg, String status, String code) {
        this.msg = msg;
        this.status = status;
        this.code = code;
    }

    public String toJson() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",this.msg);
        jsonObject.put("status",this.status);
        jsonObject.put("code",this.code);
        return jsonObject.toCompactString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(StatusPublicEnum.FAIL.toJson());
        System.out.println(StatusPublicEnum.OK.toJson());
    }

}
