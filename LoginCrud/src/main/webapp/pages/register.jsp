<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h2 class="text-center mb-4">User Registration</h2>
        <form id="registerForm">
            <!-- Full Name -->
            <div class="mb-3">
                <label for="fullName" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Enter your full name" required>
            </div>
            <!-- Username -->
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Choose a username" required>
            </div>
            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Create a password" required>
            </div>
            <!-- Confirm Password -->
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-enter your password" required>
            </div>
            <!-- Error Message -->
            <div class="text-danger mb-3" id="passwordError" style="display: none;">
                Passwords do not match. Please try again.
            </div>
            <button type="submit" class="btn btn-success w-100">Register</button>
        </form>
    </div>

    <!-- Modal for Success Message -->
    <div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Registration Successful</h5>
                </div>
                <div class="modal-body">
                    Your account has been successfully created.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="redirectButton">Continue</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Validación de contraseñas y simulación de registro exitoso
        document.getElementById("registerForm").addEventListener("submit", function (event) {
            event.preventDefault(); // Evita la acción por defecto del formulario

            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const errorMessage = document.getElementById("passwordError");

            // Validar si las contraseñas coinciden
            if (password !== confirmPassword) {
                errorMessage.style.display = "block";
                return;
            } else {
                errorMessage.style.display = "none";
            }

            // Mostrar modal de éxito
            const successModal = new bootstrap.Modal(document.getElementById("successModal"));
            successModal.show();

            // Redirigir al login al hacer clic en "Continuar"
            document.getElementById("redirectButton").addEventListener("click", function () {
                window.location.href = "../index.jsp"; // Redirigir al archivo index.jsp
            });
        });
    </script>
</body>
</html>
