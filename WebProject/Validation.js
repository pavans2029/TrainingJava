/**
 * 
 */


function checkEmptyField(fieldId) {

	alert('checkEmptyField ' + fieldId);

}

function validate() {
	var x = document.getElementById('uname').value;
	var y = document.getElementById('upass').value;

	//
	const dobInput = document.getElementById("udob");
	const dobValue = dobInput.value;

	if (!dobValue) {
		alert("Please enter your date of birth.");
		return;
	}

	const dob = new Date(dobValue);
	const today = new Date();

	const ageInMillis = today - dob;
	const ageInYears = ageInMillis / (1000 * 60 * 60 * 24 * 365.25);

	console.log(ageInYears);

	if (ageInYears <= 18) {
		alert("You are eligible as your age is " + Math.floor(ageInYears) + " years.");
		return false;
	}

	console.log('value of x ' + x);
	console.log('value of y ' + y);

	var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	if (x == "") {
		//alert('Username cannot be blank');	
		document.getElementById("nameErr").innerHTML = "Username cannot be blank";
		return false;
	}
	if (!emailRegex.test(x)) {
		document.getElementById("nameErr").innerHTML = "Invalid email format";
		return false;
	}

	if (y == "") {
		//alert('Password cannot be blank');	return false
		document.getElementById("passErr").innerHTML = "Password cannot be blank";
		return false;
	}

	if (y.length < 8) {
		document.getElementById("passErr").innerHTML = "Password must be at least 8 characters long";
		return false;
	}

	// Password complexity check: At least one number and one special character
	var regex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$/;
	if (!regex.test(y)) {
		document.getElementById("passErr").innerHTML = "Password must include at least one number and one special character";
		return false;
	}






	return true;
}

function clearTheForm() {
	document.getElementById('uname').value = "";
	document.getElementById('upass').value = "";

}

function clearNameErrMsg() {
	document.getElementById('nameErr').innerHTML = "";

}

function clearPassErrMsg() {
	document.getElementById('passErr').innerHTML = "";

}