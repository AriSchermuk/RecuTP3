package com.example.recutp3.mocks

import com.example.recutp3.entities.User

class UserMock {
    fun userMock (): List<User>{
        return listOf(
            User(
                "1",
                "Carlos",
                "https://st.depositphotos.com/1269204/1219/i/600/depositphotos_12196477-stock-photo-smiling-men-isolated-on-the.jpg",
                "AR",
                "Male"
            ),
            User(
                "2",
                "Peter",
                "https://st.depositphotos.com/1224365/2498/i/450/depositphotos_24980235-stock-photo-portrait-of-a-normal-man.jpg",
                "BR",
                "Male"
            ),
            User(
                "3",
                "Marto",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSS1lXbB3FeMDBXfB4BJE3irtdmUJTAeWLY1O6gnFuJdTNs4Io15yjcaC5FjFp3gXMKsSA&usqp=CAU",
                "MX",
                "Male"
            ),
            User(
                "4",
                "Fran",
                "https://media.gettyimages.com/photos/middle-aged-man-portrait-picture-id1285156699?s=612x612",
                "US",
                "Male"
            ),
            User(
                "5",
                "San",
                "http://static.demilked.com/wp-content/uploads/2019/04/5cb6d34f775c2-stock-models-share-weirdest-stories-photo-use-102-5cb5c725bc378__700.jpg",
                "CO",
                "Female"
            ),
            User(
                "6",
                "Fede",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPY4HpC3ilNiZF3JcZ9pj-GVla3Jvdb4xTdOi4nmNQwZcnywqXoh5q6QQ2o5uYM-tlcmE&usqp=CAU",
                "PA",
                "Male"
            ),
            User(
                "7",
                "Facu",
                "https://media.istockphoto.com/id/1169241965/photo/mature-hispanic-man-wearing-plaid-shirt.jpg?s=612x612&w=0&k=20&c=bpTU-LN4zab0TF1L_Nq-GDC3urWbO8eoRWZY0hxaa7s=",
                "EC",
                "Male"
            )
        )
    }
}