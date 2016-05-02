function validateMid() {
    return validateEmpty("mid");
}
function validatePassword() {
    return validateEmpty("password");
}
function validateCode() {
    return validateEmpty("code");
}

function validateName() {
    return validateEmpty("name");
}

function validatePhone() {
    return validateEmpty("phone");
}

function validateAddress() {
    return validateEmpty("address");
}

function validateUpdate(){
    return validateName() && validatePhone() && validateAddress();
}

function validateRegist() {
    return validateMid() && validatePassword();
}


function validateLogin() {
    return validateMid() && validatePassword() && validateRegist();
}