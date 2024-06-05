import request from "../utils/request";

export const test = () => {
    return request({
        method: "GET",
        url: "/test",
    })
};