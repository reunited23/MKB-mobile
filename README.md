# MKB-mobile

Android Studio along with UIAutomator. Programming language is kotlin.
Test case №2:

1. Launch test app
2. Press «Login» button
3. Check that message is displayed «Необходимо ввести логин и пароль»
4. Type login «autotest». Press «Login»
5. Check error message «Необходимо ввести пароль»
6. Type login «autotest». Type password «1». Press «Login»
7. Check error message «Логин или пароль введен неверно»
8. Type login «autotest». Type passsword «autotest». Press «Login»
9. Check success message
