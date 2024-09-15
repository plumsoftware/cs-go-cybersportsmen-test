package ru.plumsoftware.data.repository

import ru.plumsoftware.domain.model.Question
import ru.plumsoftware.domain.repository.QuestionsRepository

class QuestionsRepositoryImpl : QuestionsRepository {
    override fun getQuestions(): List<Question> {
        val questions = listOf(
            Question(
                "Любимая карта в CS GO",
                listOf("Inferno", "Office", "Dust 2", "Я играю на всех картах")
            ),
            Question("Любимое оружие в CS GO", listOf("AUG", "AK-47", "AWP", "Desert Eagle")),
            Question("Сколько лет играешь в CS GO", listOf("0 - 1", "2 - 4", "4 - 6", "Больше 6")),
            Question(
                "Самая не любимая карта в CS GO",
                listOf("Inferno", "Train", "Nuke", "Dust 2")
            ),
            Question("Любимый плетн на Dust 2", listOf("A", "B", "C", "D")),
            Question("Любимый плетн на Mirage", listOf("A", "B", "C", "D")),
            Question("Сколько у тебя было эйсов", listOf("0 - 1", "2 - 6", "6 - 10", "Больше 10")),
            Question(
                "Любимый режим",
                listOf("Выживание", "Соревновательный", "Напарники", "Запретная зона")
            ),
            Question(
                "Сколько раскидок на Dust 2 знаешь",
                listOf("0 - 1", "2 - 4", "4 - 6", "Больше 6")
            ),
            Question("Сколько у тебя скинов", listOf("0 - 1", "2 - 6", "6 - 10", "Больше 10")),
            Question("Любимая команда", listOf("Virtus Pro", "Navi", "Astralis", "Liquid Team")),
            Question(
                "Сколько часов в неделю играешь",
                listOf("0 - 4", "4 - 6", "6 - 12", "Больше 12")
            ),
            Question("Сколько часов в день играешь", listOf("Меньше 1", "1", "2", "Больше 2")),
            Question(
                "Твоя любимая версия игры",
                listOf(
                    "Counter-Strike 2",
                    "Counter-Strike 1.6",
                    "Counter-Strike: Global Offensive",
                    "Counter-Strike: Source"
                )
            ),
            Question(
                "Какая у тебя чувствительность мышки в игре",
                listOf("10 - 20", "20 - 50", "50 - 70", "70 - 100")
            ),
            Question(
                "Сколько часов в игре",
                listOf("Меньше 100", "100 - 200", "200 - 500", "Больше 500")
            ),
            Question(
                "На какие клавиши ходить в игре",
                listOf("W A S D", "D S W A", "← → ↑ ↓", "Пробел")
            ),
            Question("У какого оружия есть глушитель", listOf("USP", "AWP", "AK-47", "M4A1")),
            Question(
                "У какого оружия бóльший урон",
                listOf("Desert Eagle", "AWP", "M4A1", "Дробовик")
            ),
            Question("Какая граната ослепляет", listOf("Молотов", "AWP", "Осколочная", "Флэшка")),
            Question(
                "Как расшифровывается CS GO",
                listOf(
                    "Counter-Strike Global Offensive",
                    "Colic_Strike Global Offensive",
                    "Global Offensive Counter-Strike",
                    "Counter-Strike GO"
                )
            ),
            Question("Какой баланс с начала игры", listOf("100$", "1000$", "800$", "1500$")),
            Question(
                "Какое действие слышат окружающие игроки",
                listOf(
                    "Переключение зума на AWP",
                    "Переключение режима на Famas",
                    "Бросание оружия",
                    "Всё вышеперечисленное"
                )
            ),
            Question(
                "Можно ли запрыгивать на препяствия в CS GO",
                listOf("Да", "Нет", "Не на все", "Можно")
            ),
            Question(
                "Через дымовую гранату видно",
                listOf("Да", "Нет", "Видно, если пострелять", "Видно, если бросить молотов")
            ),
            Question("Сколько плентов на карте Office", listOf("2", "1", "Их нет", "3")),
            Question(
                "Сколько длится обезвреживание с4",
                listOf("10 секунд", "40 секунд", "60 секунд", "Ни один варинт не подходит")
            ),
            Question(
                "У mp9 и P90 одинаковая скорострельность",
                listOf("Правда", "Ложь", "В игре нет такого оружия", "Правда")
            ),
            Question(
                "Пули попадая в игрока замедляют его движение",
                listOf("Правда", "Ложь", "Ложь", "Правда")
            ),
            Question(
                "Как вы обычно выбираете тиммейтов в CS GO",
                listOf("По игровому стилю", "По дружбе", "Случайным образом", "Меня зовут")
            ),
            Question(
                "Как называют P90 игроки",
                listOf("Петух", "Курочка", "Лучшее оружие в игре", "пистолет-пулемёт")
            ),
            Question("Сколько дробовиков  существует в игре", listOf("1", "2", "3", "4")),
            Question("Сколько патронов у negev", listOf("90", "100", "150", "50")),
            Question(
                "Какой оружие наносит 999 урона",
                listOf("Электрошокер (зевс)", "Ножик", "AWP", "Молотов")
            ),
            Question(
                "Можно ли менять скин у персонажей",
                listOf("Да у всех", "Нет", "Не у всех", "В игре только 2 персонажа")
            ),
            Question("Скин драгон-лор на...", listOf("P90", "Galil", "AWP", "M4A4")),
            Question(
                "Какое оружие НЕ стреляет очередями",
                listOf("Famas", "Dual berretas", "Glock", "USP")
            ),
            Question(
                "Как часто ты играешь с глушителем",
                listOf("Всегда", "Часто", "Зависит от ситуации", "Никогда")
            ),
            Question(
                "Зачем ты играешь в кс го",
                listOf(
                    "Ради удовольствия",
                    "Хочу стать киберспортсменом",
                    "С друзьями веселюсь",
                    "Всё перечисленное"
                )
            ),
            Question(
                "Какое оружие стреляет очередями",
                listOf("Famas", "Negev", "Desert Eagle", "AWP")
            ),
            Question(
                "Как ты реагируешь на читеров в игре",
                listOf("Злюсь", "Веселюсь", "Кидаю репорты", "Я сам читер")
            ),
            Question(
                "Какое оружие самое мощное",
                listOf("AWP", "Scar - 20", "Револьвер", "Five seven")
            ),
            Question("Что не из игры кс го", listOf("CZ 75 auto", "AK - 47", "MAG-7", "P.U.D.G.")),
            Question("Сколько в игре пистолетов-пулеметов", listOf("3", "4", "5", "6")),
            Question(
                "Что покупаешь на первом раунде",
                listOf("Five-seven", "Броню", "Ничего", "Гранату")
            ),
            Question("С чем можно войти в прицел", listOf("Nova", "AUG", "Молотов", "Револьвер")),
            Question(
                "Какая граната наносит больше урона",
                listOf("Осколочная", "Ложная", "Флэшка", "Дымовая")
            ),
            Question("Сколько у тебя скинов", listOf("0-1", "2-4", "4-6", "Больше 6")),
            Question(
                "Зачем нужны скины в кс го",
                listOf(
                    "С ними красиво",
                    "Не нужны, портят маскировку",
                    "Просто так",
                    "С ними получается лучше играть"
                )
            ),
            Question("На что нет скина", listOf("с4", "SSG", "USP", "Galil")),
            Question("Сколько карт в игре", listOf("4", "5", "6", "Больше 6")),
            Question(
                "Что делает кнопка Shift по умолчанию",
                listOf("Для бега", "Быстро развернуться", "Медленно идти", "Быстро бросить гранату")
            ),
            Question(
                "В каком режиме есть френдли фаер",
                listOf("В соревновательном", "Бой", "Запретная зона", "Обычный")
            ),
            Question("Сколько патронов у Saffed off ", listOf("8", "9", "6", "7")),
            Question("Какое у тебя звание", listOf("Сильвер", "Глобал", "Суприм", "Беркут")),
            Question(
                "Какое звание самое высокое в игре",
                listOf("Глобал", "Кароль", "Тут нет такого", "Сильвер")
            ),
            Question(
                "Что такое ноу скоп",
                listOf(
                    "Выстрел без прицела",
                    "Выстрел в прыжке",
                    "Бесшумная ходьба",
                    "Выбросить оружие"
                )
            ),
            Question("Сколько у тебя было ноу скопов", listOf("0-2", "2-5", "5-10", "Больше 10")),
            Question(
                "На какой карте нужно спасать заложников",
                listOf("Assault", "Dust 2", "Italy", "Nuke")
            ),
            Question(
                "Сколько заложников можно спасти на карте Assault",
                listOf("Только 1", "4", "8", "Нет верного ответа")
            ),
            Question("Какой карты нет в игре", listOf("Vertigo", "Mirage", "Zoo", "Nuke")),
            Question(
                "Сколько подсадок знаешь на карте Dust 2",
                listOf("0-1", "2-3", "4-5", "Больше 5")
            ),
            //  Question("Сколько подсадок знаешь на карте Mirage", listOf("0-1", "2-3", "4-5", "Больше 5")),
            Question(
                "Сколько знаешь подсадок на карте Vertigo",
                listOf("0-2", "3-4", "5-6", "Больше 6")
            ),
            //  Question("Сколько подсадок знаешь на карте Rialto", listOf("0-2", "3-4", "5-6", "Больше 6")),
            Question(
                "Сколько существует подсадок на карте Nuke",
                listOf("0-1", "2-3", "4-5", "Больше 5")
            ),
            //  Question("Сколько подсадок знаешь на карте Assault", listOf("0-1", "2-3", "4-5", "Больше 5")),
            Question(
                "Сколько подсадок знаешь на карте Cache",
                listOf("Нет подсадок", "2-3", "4-5", "Больше 5")
            ),
            Question(
                "Сколько подсадок знаешь на карте Cobblestone",
                listOf("Нет подсадок", "2-3", "4-5", "Больше 5")
            ),
            Question(
                "Была раньше в игре карта Dust",
                listOf("Нет", "Да, была", "Планируют добавить", "Есть сейчас в игре")
            ),
            Question("Сколько званий в кс го", listOf("10", "20", "18", "25")),
            Question("Сколько званий типа Silver в кс го", listOf("8", "6", "5", "10")),
            Question("Сколько званий типа Gold nova", listOf("5", "7", "4", "3")),
            Question(
                "Сколько существует званий типа  Master Guardian в кс го",
                listOf("3", "2", "Нет такого звания", "4")
            ),
            Question(
                "Что из перечисленного НЕ пистолет",
                listOf("P2000", "Револьвер", "пп - Бизон", "USP")
            ),
            Question("Продолжи название: SSG...", listOf("20", "007", "08", "0")),
            Question("Заверши название: SG...", listOf("500", "553", "Ничего", "123")),
            Question("в игре: UMP...", listOf("2000", "008", "45", "54")),
            Question(
                "Если с USP снять глушитель, то урон увеличиться",
                listOf("Верно", "Неверно", "В кс го нет такого", "Глушитель нельзя снять")
            ),
            Question(
                "Какое оружие было в кс го 1.6",
                listOf("Щит", "Мечь", "Кулаки", "Всё перечисленное")
            ),
            Question("Сколько раундов в соревновательном режиме", listOf("15", "30", "10", "5")),
            Question(
                "Из скольки игроков состоит команда в соревновательном режиме",
                listOf("3", "5", "10", "2")
            ),
            Question(
                "Что будет, если в соревновательном режиме выйдет игрок",
                listOf(
                    "Будет бот вместо него",
                    "Команда из 4 игроков",
                    "Ничего",
                    "Игра закончиться"
                )
            ),
            Question(
                "Сколько раундов нужно выиграть, чтобы победить в соревновательном режиме в кс го",
                listOf("10", "16", "30", "29")
            ),
            Question(
                "Ты читерил в кс го",
                listOf("1 раз ради интереса", "Постоянно", "Никогда", "Не скажу")
            ),
            Question(
                "В кс го есть кейсы?",
                listOf("Нет", "Были раньше", "Да", "Планируют добавить")
            ),
            Question(
                "Зачем нужны кейсы в кс го",
                listOf(
                    "Просто так",
                    "Их нет в игре",
                    "Чтобы получить скины",
                    "Нет подходящего ответа"
                )
            ),
            Question("Сколько у тебя наклеек в кс го", listOf("0-1", "2-4", "5-8", "Больше 8")),
            Question(
                "В кс го есть наклейки на предметы?",
                listOf("Были раньше", "Да, есть в  игре", "Планируют добавить", "Нет")
            ),
            Question(
                "Что такое StatTrak в кс го?",
                listOf(
                    "Предмет с счётчиком",
                    "Такого нет в игре",
                    "Костюм на персонажа",
                    "Нет подходящего ответа"
                )
            ),
            Question("Есть ли у тебя StatTrak в кс го?", listOf("Да", "Нет", "Да", "Нет")),
            Question(
                "Существует ли в кс го консоль",
                listOf("Да", "Нет", "Да, но не во всех режимах игры", "Не знаю")
            ),
            Question(
                "Сколько консольных команд кс го знаешь",
                listOf("0-1", "2-3", "Больше 3", "Не пользуюсь консолью")
            ),
            Question("Сколько турниров по кс го смотрел", listOf("0", "1", "2", "Больше 3")),
            Question(
                "Можно ли играть в кс го без интернета",
                listOf("Да", "Нет", "Да, но не во всех режимах", "Нет подходящего ответа")
            ),
            Question("Какой бренд у твоей мышки", listOf("Razer", "Dafander", "Bloady", "Не знаю")),
            Question(
                "Какой бренд у твоих наушников",
                listOf("Bloady", "Dafander", "Razer", "Не знаю")
            ),
            Question(
                "Какой мышкой ты пользуешься",
                listOf("Проводной", "Беспроводной", "Играю на тачпаде", "Играю на джойстике")
            ),
            Question(
                "Сколько секунд обезвреживается с4 в кс го",
                listOf("Моментально", "10", "20", "15")
            ),
            Question(
                "Есть ли в кс го анимированные эмоции персонажей как в Фортнайте",
                listOf("Да", "Нет", "Не знаю", "Есть, но не у всех")
            ),
            Question(
                "Можно ли управлять транспортов в кс го как в Фортнайте",
                listOf("Да", "Нет", "Не знаю", "Можно, но не во всех режимах")
            ),
            Question("Сколько снайперок в кс го", listOf("3", "4", "5", "6")),
            Question(
                "Есть ли скины на гранаты в кс го",
                listOf("Да", "Да, но не на все", "Нет", "Не знаю")
            ),
            Question(
                "Можно ли нанести урон флешкой в кс го",
                listOf("Да", "Да, если попасть в игрока", "Нет, только ослепить", "Не знаю")
            ),
            Question(
                "Есть ли скины на перчатки в кс го",
                listOf("Да", "Нет", "В кс го нет перчаток", "Не знаю")
            ),
            Question(
                "Какой буст дают скины на перчатки в кс го",
                listOf(
                    "Уменьшают время перезарядки",
                    "Быстрее бегаешь",
                    "Никакого",
                    "Увеличивают здоровье"
                )
            ),
            Question(
                "Есть ли скины на обувь в кс го",
                listOf("Нету", "Есть", "Нет, есть только скины на перчатки", "Не знаю")
            ),
            Question(
                "Что такое \"eco round\" в CS:GO и когда его стоит применять?",
                listOf("Экологически-чистый раунд", "Не знаю", "Пистолетный раунд", "Такого нет")
            ),
            Question(
                "Что такое \"boosting\" в CS:GO и какие последствия это может иметь для игроков?",
                listOf(
                    "Не знаю",
                    "Повышения уровня игроков",
                    "Такого нет",
                    "Игра без голосового чата"
                )
            ),
            Question(
                "Самая популярная карта?",
                listOf("Dust II", "Dust", "Dragon lore", "Всё вышеперечисленное")
            ),
            Question(
                "Какие гранаты покупаешь в первую очередь в игре",
                listOf("Флешка", "Ложная", "Молотов", "Осколочная")
            ),
            Question(
                "Что даёт набор сапера в игре",
                listOf(
                    "Ускоряет обезвреживание",
                    "Ничего",
                    "Ускоряет плент бомбы в игре",
                    "В игре нет такого"
                )
            ),
            Question(
                "Сколько на карте предмета с4 в соревновательном режиме в кс го",
                listOf("5, по числу игроков", "0", "1", "2, по одной с каждой стороны")
            ),
            Question(
                "Можно ли потерять всё здоровье, если упасть с большой высоты в игре",
                listOf("Да", "Нет", "Останется 1 хп", "Не знаю")
            )
        )
        return questions.shuffled().take(20)
    }
}