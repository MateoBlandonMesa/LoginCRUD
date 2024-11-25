<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container d-flex align-items-center justify-content-center vh-100">
        <div class="card p-4 shadow" style="width: 28rem;">
            <h2 class="text-center mb-4">Update User</h2>
            
            <!-- Mostrar mensaje de error si existe -->
            <% 
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) { 
            %>
                <div class="alert alert-danger text-center" role="alert">
                    <%= errorMessage %>
                </div>
            <% } %>
            
            <!-- Obtener los atributos del usuario -->
            <% 
                String fullName = (String) request.getAttribute("fullName");
                String username = (String) request.getAttribute("username");
                String email = (String) request.getAttribute("email");
                String password = (String) request.getAttribute("password");
            %>
            
            
            <form id="updateForm" action="UpdateServlet" method="POST">
                <div class="mb-3">
                    <label for="fullName" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" value="<%= fullName %>" required>
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">Username (read-only)</label>
                    <input type="text" class="form-control" id="username" name="username" value="<%= username %>" readonly>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= email %>" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%= password %>" required>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Save Changes</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./scripts/update_user.js?v=<%= System.currentTimeMillis() %>"></script>
</body>
</html>
