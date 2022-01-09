# HILT Examples

Esse repositório possui dois projetos

- hilt-modules
- hilt-qualifiers

Esses projetos são projetos simples para ajudar a entender um pouco mais os conceitos do HILT.

## hilt-modules

Pode ser utilizado para estudos sobre `@Module`, `@Binds` e `@Provides`.

Nesse projeto você encontrará um projeto Android com uma activity, uma interface e uma classe implementando essa interface. 

``` kotlin=
class InjectionExampleImpl @Inject constructor() : InjectionExample

interface InjectionExample
````


O objetivo desse projeto é utilizar o HILT para fazer a injeção da interface na activity e observar as diferenças entre o @Binds e o @Provides.

A activity possui um botão `RECREATE` que recria a atividade, simulando uma mudança de configuração da aplicação, como por exemplo uma rotação de tela ou mudança de lingua padrão. 

```kotlin=
val btn = findViewById<Button>(R.id.recreate)
btn.setOnClickListener {
    recreate()
}
```

Esse botão possibilita explorar o funcionamento e as diferenças entre oss `scopes` e `components` existentes no HILT.

## hilt-qualifiers

Pode ser utilizado para estudos relacionado aos  `@Qualifiers`.

Nesse projeto você encontrará um projeto ainda mais simples, contendo uma activity sem layout e uma classe sendo injetada nessa activity

```kotlin=
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var myHouse : House

    ...
}
```

A classe House possui duas dependencias sendo injetadas no seu construtor

```kotlin=
class House @Inject constructor(
    private val kitchenTap: Tap,
    private val bathroomTap: Tap,
){
    ...
}
```

e as torneiras possuem implementações diferentes tanto para a cozinha quanto para o bahheiro

```kotlin= 
class KitchenTap @Inject constructor() : Tap

class BathroomTap @Inject constructor() : Tap

interface Tap
```

O objetivo desse projeto é utilizar o HILT e os Qualifiers para fazer a injeção de uma implementação diferente para cada tipo de torneira injetada na classe House.


