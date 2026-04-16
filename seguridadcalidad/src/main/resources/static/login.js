document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        console.log('-> Frontend: POST /api/auth/login username=', username);
        const response = await fetch('/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });
        console.log('<- Frontend: POST /api/auth/login status=' + response.status);

        if (!response.ok) {
            const errorText = await response.text();
            console.error('Frontend: POST /api/auth/login error response=', errorText);
            document.getElementById('errorMessage').textContent = errorText;
            return;
        }

        const data = await response.json();
        console.log('<- Frontend: POST /api/auth/login token received');
        localStorage.setItem('jwtToken', data.token);
        window.location.href = '/home';
    } catch (error) {
        console.error('Frontend: POST /api/auth/login error=', error);
        document.getElementById('errorMessage').textContent = 'Error de conexión al backend.';
    }
});