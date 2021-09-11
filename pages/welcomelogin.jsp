<html>
 <link rel="shortcut icon"  href="/static/images/birdtwitter.jpg"/>
<head>

    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous">
      </script>

    <style>

      * {
        box-sizing: border-box;
      }
      body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
      }
      .container {
        padding: 2rem;
        margin: 4rem auto;
        max-width: 400px;
        background-color: #fff;
        border-radius: 8px;
      }
      h1 {
        font-size: 2rem;
        line-height: 2.5rem;
        font-weight: 500;
        margin-bottom: 2rem;
      }
      .floating-label {
        position:  relative;
        margin-bottom:  1.5rem;
        //height: 72px;
      }

      .label {
        position:  absolute;
        top: 0;
        left:  0.625rem;
        opacity:  0;
        font-size: 0.875rem;
        line-height: 1rem;
        font-weight: 600;
        padding: 0 0.25rem;
        color: #666666;
        transition:  all .3s ease;
        display: block;
        background-color: #fff;
      }
      .optional {
        position:  absolute;
        top: -0.5rem;
        right:  0.625rem;
        text-align: right;
        font-style: italic;
        font-size: 0.875rem;
        line-height: 1rem;
        padding: 0 0.25rem;
        color: #666666;
        display: block;
        background-color: #fff;
      }

      .help-error-text {
        padding: 0.25rem 0.875rem 0;
        font-size: 0.875rem;
        line-height: 1.25rem;
        color: #666666;
      }

      label.error {
        display: block;
        font-size: 0.875rem;
        line-height: 1.25rem;
        color: #E33847;
      }

       input:not(:placeholder-shown) {
         //padding:  28px 0px 12px 0px;
       }
       input:not(:placeholder-shown) + label {
         transform:  translateY(-0.5rem);
         opacity:  1;
       }

      input {
        box-sizing:  border-box;
        transition:  all .3s linear;
        -webkit-appearance:  none;
        font-size: 1.125rem;
        line-height: 1.5rem;
        padding: 0.625rem 0.75rem;
        border: 2px solid #EBEBEB;
        border-radius: 0.25rem;
        width: 100%;
        &.error {
          /*border-color: #E33847;
          & + label.label {
            color: #E33847;
          }*/
        }
        &:focus, &.error:focus  {
          outline: 0;
          border-color: #39AEFF;
          & + .label {
            color: #39AEFF;
          }
        }
      }

      input::placeholder {
        color: #9F9F9F;
      }

      .button {
        box-sizing:  border-box;
        transition:  all .3s linear;
        -webkit-appearance:  none;
        font-size: 1.125rem;
        line-height: 1.5rem;
        padding: 0.625rem 0.75rem;
        border-radius: 0.25rem;
        border: none;
        background-color: #39AEFF;
        color: #fff;
        margin-right: 0.5rem;
        width: 100%;
        &:hover, &:focus {
          background-color: #2C8FD4;
          transition:  all .3s ease;
        }
        &:focus {
          outline: none;
        }
        &:hover {
          cursor: pointer;
        }
      }

      .password-toggle {
        top: 0.5rem !important;
        margin: 0 !important;
        font-size: 0.75rem;
        letter-spacing: 0.04rem;
        font-weight: 500;
        line-height: 1.5rem;
        padding: 0.25rem 0.5rem;
        border-radius: 0.125rem;
        border: none;
        color: #4D5860;
        text-transform: uppercase;
        background-color: #DCE3E9;
        transition:  all .3s ease;
        &:focus {
          outline: none;
          background-color: #c2c9cf;
          transition:  all .3s ease;
        }
      }

      @media only screen and (min-width: 480px) {
        body {
          background-color: #39AEFF;
        }
        .container {
          padding: 2.5rem;
        }
      }

    </style>
</head>

<body>
<section id="sign-up">
    <div class="container">
      <h1>Login</h1>
      <form id="signup-form" >
        <div class="floating-label">
          <input id="email" name="Email" type="email" placeholder="Email"/>
          <label class="label" for="email">Email</label>
          <div class="help-error-text"></div>
        </div>
        <div class="floating-label">
          <input id="password" name="Password" type="password" placeholder="Password" minlength="4"/>
          <label class="label" for="password">Password</label>
          <div class="help-error-text">At least 4 characters</div>
        </div>

        <p style="color:red; display:none" id="signup-error"></p>
        <button class="button" id="btn-signup" type="button">Login</button>
      </form>
    </div>
</section>

    <script>

             function validateSignupForm(){
                     var email=$("#email").val();
                     var password=$("#password").val();

                     var error="";

                    if(!email){
                        error+="Email is empty.";
                    }

                    if(!password){
                       error+="Password is empty.";
                     }

                    if(password.length<=4){
                        error+="Password length  must be greater than 4 characters.";
                    }

                     $("#signup-error").html(error);

                    if(error.length>0){
                      return false;
                    }
                   return true;
                }

             $("#btn-signup").click(function(){
                debugger;
                var isValidForm=validateSignupForm();

                if(isValidForm){
                           $("#signup-error").hide();
                           var email=$("#email").val();
                           var password=$("#password").val();

                            var user={
                            "email":  email,
                            "password": password
                            } ;

                        $.ajax({
                         type: "post",
                          url: "/login/welcome",
                          data:JSON.stringify(user),
                          success:function(response){
                            if(!!response){
                                if(response.is_logined ===true){
                                location.href="/welcome";
                                }else{
                                    $("#signup-error").html(response.message);
                                }
                             }
                          },
                          contentType: 'application/json'
                         });
                 }
                 else
                 {
                 $("#signup-error").show();
                 }
            });
    </script>

</body>
</html>
