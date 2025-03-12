function getUserInfo() {
    let data = {}
    data['name'] =  document.getElementById("name").value.trim();
    data['mail'] = document.getElementById("mail").value.trim();
    data['password'] = document.getElementById("password").value.trim();
    data['password-repeat'] = document.getElementById('password-repeat').value;
    if(data['password-repeat'] != data['password']){
        return null;
    } 
    return data;
}

function checkUserInfo(info){
    if (info == null){
        return -1;
    }
    if (info['name'] == null || info['name'] == '')
    {
        alert('name can not be null')
        return -1;
    }else if(info['mail'] == null || info['mail'] == '')
    {
        alert('mail can not be null')
        return -1;
    }
    else if(info['password'] == null || info['password'] == '')
    {
            alert('password can not be null')
            return -1;
    }
    // console.log(info)
    return 0;
}

function fetchResponse(url,info) {
     // 发起请求
     fetch(
        //接口URL
        url,
        // 向接口发送的httpRequest的参数:请求头 header 请求体 body
        {
            // 请求头
            headers:{
                'Content-Type': 'application/json',
            },
            method:'POST',
            // 请求体
            body:JSON.stringify(info)
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
            console.log('注册成功:',data);
            // window.location.href = user.getURL() + data.redirect;
            // window.Location = data.url;
            // 处理登录成功后的逻辑，例如保存token等
    })
    // 如果fetch失败,js会catch错误信息
    .catch(error => {
        console.error('登录失败:', error);
        // 处理登录失败的情况
    })
}


function sendRequest() {
    const regURL = "192.168.3.116:8080/chatRoom/register/sendInfo"
    let info = getUserInfo();
    const status = checkUserInfo(info);
    if (status == -1){return;}
    fetchResponse(regURL,info);
}


let submitBtn = document.getElementById("submit")
submitBtn.addEventListener('click',sendRequest)
