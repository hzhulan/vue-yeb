<template>
    <div class="login">
        <el-form
                :rules="rules"
                ref="loginForm"
                :model="loginForm"
                class="loginContainer"
        >
            <h3 class="loginTitle">系统登录</h3>
            <el-form-item prop="username">
                <el-input
                        type="text"
                        v-model="loginForm.username"
                        placeholder="请输入用户名"
                ></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input
                        type="password"
                        v-model="loginForm.password"
                        placeholder="请输入密码"
                ></el-input>
            </el-form-item>
            <el-form-item prop="code" id="verifyCodeItem">
                <div style="display: flex;align-items: center">
                    <el-input
                            type="password"
                            auto-complete="false"
                            v-model="loginForm.code"
                            placeholder="点击图片更换验证码"
                            style="width: 250px; margin-right: 5px"
                    ></el-input>
                    <img id="verifyCodeImg" :src="captureUrl"/>
                </div>

            </el-form-item>
            <el-checkbox v-model="checked" class="loginRememberMe"
            >记住我
            </el-checkbox
            >
            <el-button type="primary" style="width: 100%" @click="submitLogin"
            >登录
            </el-button
            >
        </el-form>
    </div>
</template>

<script>
    import {postRequest} from '../utils/api.js';

    export default {
        name: "Login",
        data() {
            return {
                loginForm: {
                    username: "张三",
                    password: "wllssd",
                    code: "RRGK"
                },
                checked: true,
                captureUrl: "",
                rules: {
                    username: [{required: true, message: "请输入用户名", trigger: "blur"}],
                    password: [{required: true, message: "请输入密码", trigger: "blur"}],
                    code: [{required: true, message: "请输入验证码", trigger: "blur"}]
                },
            };
        },
        methods: {
            submitLogin() {
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        this.$message.error('请按照要求填写');
                        return false;
                    }
                });
            },
        },
        mounted() {
            postRequest('/api/img', {}).then(res => {
                console.log(res)
                this.captureUrl = res.data.img;
            });
        }
    };
</script>

<style scoped>
    .loginContainer {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        padding: 15px 35px 15px 35px;
        width: 350px;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }

    .loginTitle {
        margin: 10px auto 20px auto;
        text-align: center;
    }

    .loginRememberMe {
        text-align: left;
        margin: 0 auto 20px auto;
    }

    #verifyCodeImg {
        width: 100px;
        height: 40px;
    }
</style>