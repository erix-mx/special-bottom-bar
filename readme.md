# Special Bottom Bar

Special Bottom Bar en una barra de navegación diseñada y creada para el proyecto https://github.com/DerSarco/PetPalPlaces.

![SBBSS01.png](https://firebasestorage.googleapis.com/v0/b/basic-calculator-001-c2092.appspot.com/o/SBBSS01.png?alt=media&token=9b3f864d-0796-44cf-b609-81d95987b1f2&_gl=1*1l6bmtm*_ga*MTcxMTQyNzU4Ny4xNjIyNDg1NTgx*_ga_CW55HF8NVT*MTY4NTkzNDQ5NC40LjEuMTY4NTkzNDU5Mi4wLjAuMA..)

## Normal Navigation Bottom Bar

Configuración de theme

```kotlin
val bottomBarTheme = SpecialBottom.Theme(
    //Shadow
    shadowColor = MaterialTheme.colorScheme.onBackground,
    backgroundColor = MaterialTheme.colorScheme.background,

    //Item
    selectedColor = MaterialTheme.colorScheme.primary,
    unselectedColor = MaterialTheme.colorScheme.onBackground,
)

```

Configuración de items en Navigation Bottom Bar

```kotlin
@Composable
fun MyBottomBar(
    currentSelected: SpecialBottom.Id = SpecialBottom.Id("explore"),
    onItemSelected: (SpecialBottom.Id) -> Unit
) {
	SpecialBottomBar(
	    theme = bottomBarTheme,
	    menuItems = listOf(
	        SpecialBottom.Item(
	            icon = R.drawable.ic_outline_home,
	            activatedIcon = R.drawable.ic_fill_home,
	            tag = "Home",
	            id = SpecialBottom.Id("home"),
	        ),
	
	        SpecialBottom.Item(
	            icon = R.drawable.ic_outline_message,
	            activatedIcon = R.drawable.ic_fill_message,
	            tag = "Messages",
	            id = SpecialBottom.Id("post"),
	            badge = SpecialBottom.Badge(
	                text = "1",
	                backgroundColor = MaterialTheme.colorScheme.primary,
	                textColor = MaterialTheme.colorScheme.background
	            )
	        ),
	        ....
	    ),
	    currentSelected = currentSelected,
	    onItemSelected = onItemSelected,
	
	)
}
```

## Configurar Badge

![SBBSS03.png](https://firebasestorage.googleapis.com/v0/b/basic-calculator-001-c2092.appspot.com/o/SBBSS02.png?alt=media&token=73b28fa7-9f16-48b9-9724-ef53172ad79d&_gl=1*1mo1siq*_ga*MTcxMTQyNzU4Ny4xNjIyNDg1NTgx*_ga_CW55HF8NVT*MTY4NTkzNDQ5NC40LjEuMTY4NTkzNDU5OC4wLjAuMA..)

Badge con algún texto

```kotlin
SpecialBottom.Item(
      icon = R.drawable.ic_outline_message,
      activatedIcon = R.drawable.ic_fill_message,
      tag = "Messages",
      id = SpecialBottom.Id("post"),
      badge = SpecialBottom.Badge(
          text = "1",
          backgroundColor = MaterialTheme.colorScheme.primary,
          textColor = MaterialTheme.colorScheme.background
      )
  ),
```

Badge simple

```kotlin
SpecialBottom.Item(
    icon = R.drawable.ic_outline_notify,
    activatedIcon = R.drawable.ic_fill_nority,
    tag = "Notifications",
    id = SpecialBottom.Id("notifications"),
    badge = SpecialBottom.Badge(
        backgroundColor = MaterialTheme.colorScheme.primary,
        textColor = MaterialTheme.colorScheme.background
    )
)
```

## Normal Navigation Bottom Bar Plus

Esta versión agrega un botón principal en el centro del Navigation Bottom Bar

![SBBSS02.png](https://firebasestorage.googleapis.com/v0/b/basic-calculator-001-c2092.appspot.com/o/SBBSS03.png?alt=media&token=2ca08b79-bbe9-4cd4-99ee-9bdddbdeb38d&_gl=1*4q2k0b*_ga*MTcxMTQyNzU4Ny4xNjIyNDg1NTgx*_ga_CW55HF8NVT*MTY4NTkzNDQ5NC40LjEuMTY4NTkzNDYwNS4wLjAuMA..)

```kotlin
@Composable
fun BottomBarPlus(
    currentSelected: SpecialBottom.Id = SpecialBottom.Id("explore"),
    onItemSelected: (SpecialBottom.Id) -> Unit
) {
	
	val bottomBarTheme = SpecialBottom.Theme(
    //Shadow
    shadowColor = MaterialTheme.colorScheme.onBackground,
    backgroundColor = MaterialTheme.colorScheme.background,

    //Item
    selectedColor = MaterialTheme.colorScheme.primary,
    unselectedColor = MaterialTheme.colorScheme.onBackground,

    //Plus button
    iconPlus = R.drawable.ic_add,
    backGroundSecondaryColor = MaterialTheme.colorScheme.secondary,
	)

	SpecialBottomBarPlus(
	    theme = bottomBarTheme,
	    menuItems = listOf(
	        SpecialBottom.Item(
	            icon = R.drawable.ic_outline_home,
	            activatedIcon = R.drawable.ic_fill_home,
	            tag = "Home",
	            id = SpecialBottom.Id("home"),
	        ),
	
	        SpecialBottom.Item(
	            icon = R.drawable.ic_outline_message,
	            activatedIcon = R.drawable.ic_fill_message,
	            tag = "Messages",
	            id = SpecialBottom.Id("post"),
	            badge = SpecialBottom.Badge(
	                text = "1",
	                backgroundColor = MaterialTheme.colorScheme.primary,
	                textColor = MaterialTheme.colorScheme.background
	            )
	        ),
	        ....
	    ),
	    currentSelected = currentSelected,
	    onItemSelected = onItemSelected,
	
	)

}
```

Importante actualizar el composable a: `SpecialBottomBarPlus`

Agradecimientos a [@DerSarco](https://github.com/DerSarco) y [@Afalabarce](https://github.com/afalabarce) por la oportunidad de participar en sus proyectos así también por su grandiosa **Mentoría**.

```
MIT License

Copyright (c) 2023 DerSarco Carlos Muñoz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```