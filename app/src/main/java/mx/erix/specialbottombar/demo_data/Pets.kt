package mx.erix.specialbottombar.demo_data

data class Pet(
    val name: String,
    val url: String
)

val pets: List<Pet> = listOf(
    Pet("Buddy", "https://images.pexels.com/photos/895259/pexels-photo-895259.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"),
    Pet("Max", "https://images.pexels.com/photos/4587987/pexels-photo-4587987.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Luna", "https://images.pexels.com/photos/2023384/pexels-photo-2023384.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Charlie", "https://images.pexels.com/photos/3104709/pexels-photo-3104709.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Rocky", "https://images.pexels.com/photos/3361739/pexels-photo-3361739.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Daisy", "https://images.pexels.com/photos/3196887/pexels-photo-3196887.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Bella", "https://images.pexels.com/photos/4056462/pexels-photo-4056462.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Cooper", "https://images.pexels.com/photos/4588435/pexels-photo-4588435.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Milo", "https://images.pexels.com/photos/15347387/pexels-photo-15347387/free-photo-of-resfriado-invierno-animal-montana.jpeg?auto=compress&cs=tinysrgb&w=1600"),
    Pet("Lucy", "https://images.pexels.com/photos/16623449/pexels-photo-16623449/free-photo-of-adopta-un.jpeg?auto=compress&cs=tinysrgb&w=1600")
)