1. import as existing maven projects
2. configure db connection στο user-login-service -> src/main/resources -> application.properties
3. ανοιχτή βάση και μετά run as java application με τη σειρά 
    α) NetflixEurekaNamingServerApplication
    β) UserLoginServiceApplication
    γ) NetflixZuulApiGatewayServerApplication
4. το url είναι http://localhost:8000/users/login