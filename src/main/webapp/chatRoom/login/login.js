// 基本的接口信息 base

class base{
    // 构造函数
    constructor(){
        this.url = "http://192.168.3.116:8080/chatRoom";
        this.api = {
            "login":"/api/login",
        }
    }
    // 去除左右两边空格
    static strip(str){return str.trim()} 

    getURL(){return this.url}
    getAPI(){return this.api}

}

// 用户登录信息 UserInfo 继承了基本的接口信息 base
class UserInfo extends base {
    // 构造函数
    constructor() {
        super()
        this.nameElement = document.getElementById("name");
        this.pwndElement = document.getElementById("pwnd");
        this.name = null;
        this.pwnd = null;
    }

    getUserInfo(){
        this.name = base.strip(this.nameElement.value);
        this.pwnd = base.strip(this.pwndElement.value);
    }

}

// 发送请求 LoginRequest
class LoginRequest{
    // 构造函数
    constructor(button,method='GET'){
        this.method = method;
        this.loginButton = button;
        this.loginButton.addEventListener('click',this.sendLoginRequest);
    }

    sendLoginRequest(){
        let user = new UserInfo();
        user.getUserInfo();

        if (user.name == "" || user.name == null ){
            user.nameElement.value = "";
            user.pwndElement.value = "";
            alert("帐号不能为空!");
            return;
        }
        if (user.pwnd == ""|| user.pwnd == null){
            user.pwndElement.value = "";
            alert("密码不能为空!");
            return;
        }
        
        const data = {
            "userName":user.name,
            "userPwnd":user.pwnd
        };
        let loginAPI = user.getURL() + user.getAPI()["login"];
        

        // 发起请求
        fetch(
            //接口URL
            loginAPI,
            // 向接口发送的httpRequest的参数:请求头 header 请求体 body
            {
                // 请求头
                headers:{
                    'Content-Type': 'application/json',
                },
                method:'POST',
                // 请求体
                body:JSON.stringify(data)
            }
        )
        // 接收响应:响应头处理 箭头函数:response作参数 省去函数名
        .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json(); // 解析JSON数据
        })
        // 接收数据:数据处理
        .then(data => {
                // console.log('登录成功:');
                window.location.href = user.getURL() + data.redirect;
                // window.Location = data.url;
                // 处理登录成功后的逻辑，例如保存token等
        })
        // 如果fetch失败,js会catch错误信息
        .catch(error => {
            console.error('登录失败:', error);
            // 处理登录失败的情况
        })
    }
}


 // 发送登录请求

let loginButton = document.getElementById("loginButton");
let login = new LoginRequest(loginButton);






