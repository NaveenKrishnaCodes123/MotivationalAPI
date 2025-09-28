package com.ecomartx.practise1

import androidx.compose.runtime.Composable

@Composable
fun UserListScreen() {
    // Sample data
    val users = listOf(
        "Naveen",
        "Krishna",
        "Android Dev",
        "Jetpack Compose",
        "Factory Pattern",
        "Builder Pattern"
    )
}

   /* // LazyColumn works like RecyclerView
    LazyColumn {
        items(users) { user ->
            UserItems(user)
        }
    }
}

@Composable
fun UserItems(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}*/


