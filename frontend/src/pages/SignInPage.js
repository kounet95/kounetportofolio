import React from 'react'

const SignInPage = () => {
  return (
            <div className="container">
            <div className="row justify-content-center mt-5">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-body">
                            <h3 className="card-title text-center">Login</h3>
                            <div className="d-grid gap-2 mb-3">
                                <a href="#" className="btn btn-social btn-google">
                                <i className="fa-brands fa-google"></i> Sign in with Google
                                </a>
                                <a href="#" className="btn btn-social btn-facebook">
                                <i className="fa-brands fa-facebook"></i> Sign in with Facebook
                                </a>
                                <a href="#" className="btn btn-social btn-twitter">
                                <i className="fa-brands fa-x-twitter"></i> Sign in with Twitter
                                </a>
                            </div>
                            <p className="divider-text">
                                <span className="bg-light">OR</span>
                            </p>
                            <form>
                                <div className="mb-3">
                                    <label for="email" className="form-label">Email address</label>
                                    <input type="email" className="form-control" id="email" required/>
                                </div>
                                <div className="mb-3">
                                    <label for="password" className="form-label">Password</label>
                                    <input type="password" className="form-control" id="password" required/>
                                </div>
                                <div className="mb-3 form-check">
                                    <input type="checkbox" className="form-check-input" id="rememberMe"/>
                                    <label className="form-check-label" for="rememberMe">Remember me</label>
                                </div>
                                <div className="d-grid">
                                    <button type="submit" className="btn btn-primary">Login</button>
                                </div>
                            </form>
                            <div className="text-center mt-3">
                                <a href="#" className="text-decoration-none">Forgot password?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  )
}

export default SignInPage
