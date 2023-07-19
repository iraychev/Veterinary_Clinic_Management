async function basiclogin(email, pass) {
    const response = await zlFetch.post(loginEndpoint, {
        auth: {
            username: email,
            password: pass
        },
        body: { /*...*/ }
    })
}
