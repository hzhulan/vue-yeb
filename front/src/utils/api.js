import axios from 'axios'
import { Message } from 'element-ui'
import router from '../router';
import routes from '../router'

// 响应拦截器
axios.interceptors.response.use(success => {
    if (success.status && success.status === 200) {
        if (success.data.code !== 200) {
            Message.error({ message: success.data.message });
            return;
        }
        if (success.data.message) {
            Message.success(success.data.message);
        }

    }
    return success.data;
}, error => {
    if (error.response.code == 401) {
        Message.error("尚未登录，即将跳转登录页面");
        router.replace('/');
    } else {
        Message.error({ message: '服务器访问失败' });
    }
    return;
});

let base = '';

// 传送json格式请求
export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params
    });
}