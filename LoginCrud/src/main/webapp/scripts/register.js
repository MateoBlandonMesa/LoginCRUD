document.getElementById("registerForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission
    
    const password = document.getElementById("password").value.trim();
    const confirmPassword = document.getElementById("confirmPassword").value.trim();

    // Validate that password is not empty
    if (!password) {
        alert("Password cannot be empty. Please enter a valid password.");
        return;
    }

    // Validate that password and confirm password match
    if (password !== confirmPassword) {
        //prompt("Hola pruebas");
        //debugger;
        alert("Passwords do not match. Please try again.");
        return;
    }

    document.getElementById("registerForm").submit();
});
