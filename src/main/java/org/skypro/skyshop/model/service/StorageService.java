package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    /*public StorageService(Map<UUID, Product> products, Map<UUID, Article> articles) {
        this.products = products;
        this.articles = articles;
    }*/
    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        createTestData();
    }

    public Collection<Product> returnProducts() {
        return products.values();
    }

    public Collection<Article> returnArticles() {
        return articles.values();
    }

    private void createTestData() {
        SimpleProduct banana = new SimpleProduct("Банан", 320, UUID.randomUUID());
        this.products.put(banana.getId(), banana);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 410, 5, UUID.randomUUID());
        this.products.put(apple.getId(), apple);
        SimpleProduct bread = new SimpleProduct("Хлеб", 54, UUID.randomUUID());
        this.products.put(bread.getId(), bread);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 650, 12, UUID.randomUUID());
        this.products.put(meat.getId(), meat);
        FixPriceProduct sugar = new FixPriceProduct("Сахар", UUID.randomUUID());
        this.products.put(sugar.getId(), sugar);
        SimpleProduct milk = new SimpleProduct("Молоко", 132, UUID.randomUUID());
        this.products.put(milk.getId(), milk);
        SimpleProduct fish = new SimpleProduct("Рыба", 740, UUID.randomUUID());
        this.products.put(fish.getId(), fish);
        SimpleProduct fish1 = new SimpleProduct("Рыба", 1500, UUID.randomUUID());
        this.products.put(fish1.getId(), fish1);


        Product beer = new SimpleProduct("пиво", 115, UUID.randomUUID());
        this.products.put(beer.getId(), beer);
        Product orange = new SimpleProduct("апельсин", 180, UUID.randomUUID());
        this.products.put(orange.getId(), orange);

        FixPriceProduct tea = new FixPriceProduct("чай", UUID.randomUUID());
        this.products.put(tea.getId(), tea);

        Article buckwheat = new Article("Как варить гречку", "Статья про приготовление блюд из гречневой крупы. \n " +
                "Для проверки мы дабавим слово крупа еще раз, а затем еще раз укрупненно", UUID.randomUUID());
        this.articles.put(buckwheat.getId(), buckwheat);
        Article wallpaper = new Article("Поклейка обоев своими руками", "Статья о самостоятельном наклеивание " +
                "рулонных обоев.\n" +
                "570 рублей за квадратный метр. Да-да, именно столько придется заплатить, чтобы рабочие из ремонтной " +
                " фирмы поклеили обои в комнате по стандартной схеме с удалением старых, нанесением грунтовки и  " +
                "шпаклевки и выравниванием стен. А теперь подсчитайте, во сколько обойдется вся квартира!  И это без " +
                "стоимости обоев!\n" +
                "Предлагаем вам сэкономить и поклеить обои самостоятельно. Мы подробно расскажем вам, как сделать " +
                "так, чтобы оклейка обоев прошла на ура и с результатом 100%.", UUID.randomUUID());
        this.articles.put(wallpaper.getId(), wallpaper);
        Article rice = new Article("Как сварить рисовую крупу", "Статья про приготовление блюд из рисовой крупы. ведь" +
                " рисовая крупа всем крупам крупа", UUID.randomUUID());
        this.articles.put(rice.getId(), rice);
        Article salo = new Article("Как засолить сало в домашних условиях", "Несколько простых рецептов по засолке " +
                "сала.", UUID.randomUUID());
        this.articles.put(salo.getId(), salo);


        SimpleProduct appleGold = new SimpleProduct("Яблоко Gold", 600, UUID.randomUUID());
        this.products.put(appleGold.getId(), appleGold);

//        this.products.put(appleGold.getId(), appleGold);
        DiscountedProduct appleGoldDiscont = new DiscountedProduct("Яблоко Gold", 520, 17, UUID.randomUUID());
        this.products.put(appleGoldDiscont.getId(), appleGoldDiscont);
        FixPriceProduct milkDiscont = new FixPriceProduct("Молоко Эконом", UUID.randomUUID());
        this.products.put(milkDiscont.getId(), milkDiscont);

//        this.products.put(milkDiscont.getId(), milkDiscont);
        Article apples = new Article("Длительное хранение яблок в условиях городских квартир", "Лучшим местом для " +
                "хранения яблок в городской квартире всегда был и остается застекленный балкон или лоджияю Потому что" +
                " яблоки требуют прохлады, идеальная температура хранения для них от -2°С до +5°С.", UUID.randomUUID());
        this.articles.put(apples.getId(), apples);

       /* Article article1 = new Article("Безопасность мореплавания.", "Средства навигационного оборудования - самая важная отрасль.", UUID.randomUUID());
        this.articles.put(article1.getId(), article1);
        Article article2 = new Article("Маяки России.", "Первый этап проекта — электронная энциклопедия российских исторических маяков.", UUID.randomUUID());
        this.articles.put(article2.getId(), article2);
        Article article3 = new Article("Маяки народов России.", "Второй этап проекта — сбор и оцифровка фотоархивов.", UUID.randomUUID());
        this.articles.put(article3.getId(), article3);*/
    }

//    @GetMapping("/searchable")
    public Collection<Searchable> getAllSearchable() {
        return Stream.concat(products.values().stream(),articles.values().stream()).collect(Collectors.toList());
    }

}
