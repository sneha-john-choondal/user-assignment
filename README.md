# user-assignment

please find the endpoints below. used the default server port here.
list users :
http://localhost:8080/user/listUsers

createUser:
http://localhost:8080/user/addUser
request :
{
        "name": "give name",
        "email": "give any email id",
        "password": "give any password",
        "loginDate": "any date"
    }

update user:
http://localhost:8080/user/updateUser/{id}
request:
{
        "name": "give name",
        "email": "give any email id",
        "password": "give any password",
        "loginDate": "any date"
    }

delete user :
http://localhost:8080/user/deleteUser/{id}

login:
http://localhost:8080/user/login?email=(give email id)&password=( give password)




