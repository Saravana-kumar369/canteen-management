export const BASE_URL = "http://localhost:8080";

export const API_PATHS = {
    USER:{
        USER_LOGIN: "/user/login",
    },

    FOOD:{
        ADD_FOOD: "/food/add",
        GET_FOOD: "/food/allfood",
        UPDATE_FOOD: "/food/update",
        DELETE_FOOD: "/food/delete",
    },

    ORDER:{
        ADD_ORDER: "/order/add",
    },

    ITEM:{
        ADD_ITEM: "/item/add",
        GET_ITEM:(orderid)=> `/item/id${orderid}`,
    },
    PAYMENT:{
        ADD_PAYMENT: "/payment/add",
        GET_PAYMENT: "/payment/all",
    }

}
