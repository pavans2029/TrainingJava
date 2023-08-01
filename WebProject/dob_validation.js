// JavaScript
function calculateAge() {
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
  
    if (ageInYears >= 18) {
      alert("You are eligible as your age is " + Math.floor(ageInYears) + " years.");
    } else {
      alert("You must be at least 18 years old.");
    }
  }
  