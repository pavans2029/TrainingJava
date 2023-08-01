/**
 * 
 */


function checkEmptyField(fieldId) {

    alert('checkEmptyField ' + fieldId);

}

function validate() {
    var x = document.getElementById('email').value;
    var y = document.getElementById('upass').value;
    var z = document.getElementById('reUpass').value;


    // email validation
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (x == "") {
        alert('email cannot be blank');	
        // document.getElementById("nameErr").innerHTML = "Username cannot be blank";
        return false;
    }
    if (!emailRegex.test(x)) {
        alert("Invalid email format");
        // document.getElementById("nameErr").innerHTML = "Invalid email format";
        return false;
    }

    console.log('value of x ' + x);


    //password validation
    if (y == "") {
        //alert('Password cannot be blank');	return false
        alert("Password cannot be blank");
        // document.getElementById("passErr").innerHTML = "Password cannot be blank";
        return false;
    }

    if (y.length < 8) {
        alert("Password must be at least 8 characters long");
        // document.getElementById("passErr").innerHTML = "Password must be at least 8 characters long";
        return false;
    }

    // Password complexity check: At least one number and one special character
    var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$/;
    if (!regex.test(y)) {
        alert("Password must include at least one number and one special character");
        // document.getElementById("passErr").innerHTML = "Password must include at least one number and one special character";
        return false;
    }

    const userType = document.querySelector('input[name="usertype"]:checked').value;
    // const username = document.getElementById('username').value;
    // const password = document.getElementById('upass').value;

    if(y==z){
        console.log("hello world");
    }else{
        alert("Password mismatch");
        return false;
    }


    if (userType === 'user') {
        window.location.href = 'user.html';
    } else if (userType === 'retail') {
        window.location.href = 'retail.html';
    }


    return true;
}

function clearTheForm() {
    document.getElementById('email').value = "";
    document.getElementById('upass').value = "";

}

function clearNameErrMsg() {
    document.getElementById('nameErr').innerHTML = "";

}

function clearUserNameErrMsg() {
    document.getElementById('userNameErr').innerHTML = "";

}

function clearPassErrMsg() {
    document.getElementById('passErr').innerHTML = "";

}