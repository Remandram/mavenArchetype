// 登录注册页面转换
const container = document.querySelector('#container');
// const form1 = document.querySelector('#form1');

const signInButton = document.querySelector('#signIn');
const signUpButton = document.querySelector('#signUp');
const Addclick=()=>{
    // form1.setAttribute('style',"visibility: hidden;")
    container.classList.add('right-panel-active')
}
const Removeclick=()=>{
    // form1.setAttribute('style',"visibility: visible;")
    container.classList.remove('right-panel-active')
}
signUpButton.addEventListener('click',Addclick)
signInButton.addEventListener('click',Removeclick)
