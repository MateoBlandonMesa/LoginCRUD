document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    // Simulate registered users (in real app, search in server)
    const registeredUsers = [
        { username: "john_doe", password: "123" },
        { username: "jane_doe", password: "123" }
    ];

    // Validate if the user exist
    const userExists = registeredUsers.some(user => user.username === username && user.password === password);

    if (!userExists) {
        alert("Invalid username or password. Please try again.");
        return;
    }

    // If the user does exist, allow form submission
    alert("Login successful! Redirecting...");
    this.submit();
});
