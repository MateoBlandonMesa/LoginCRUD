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
        alert("Passwords do not match. Please try again.");
        return;
    }

    // Simulate successful registration (Replace with actual API call)
    const successModal = new bootstrap.Modal(document.getElementById('successModal'));
    successModal.show();

    document.getElementById("redirectButton").addEventListener("click", function () {
        window.location.href = "../index.jsp"; // Redirect to the login page
    });
});
