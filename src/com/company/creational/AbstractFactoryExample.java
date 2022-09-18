package com.company.creational;

interface Comedy {
    String getName();
}
interface Documentary {
    String getName();
}
interface Historical {
    String getName();
}
interface AbstractFactory {
    Comedy getComedy();
    Documentary getDocumentary();
    Historical getHistorical();
}
//Pixar's films
class PixarComedy implements Comedy{
    @Override
    public String getName() {
        return "Pixar Comedy";
    }
}
class PixarDocumentary implements Documentary{
    @Override
    public String getName() {
        return "Pixar Documentary";
    }
}
class PixarHistorical implements Historical{
    @Override
    public String getName() {
        return "Pixar Historical";
    }
}
//Blue Sky's films
class BlueSkyComedy implements Comedy{
    @Override
    public String getName() {
        return "Blue Sky Comedy";
    }
}
class BlueSkyDocumentary implements Documentary{
    @Override
    public String getName() {
        return "Blue Sky Documentary";
    }
}
class BlueSkyHistorical implements Historical{
    @Override
    public String getName() {
        return "Blue Sky Historical";
    }
}

class PixarFactory implements AbstractFactory {
    @Override
    public Comedy getComedy() {
        return new PixarComedy();
    }

    @Override
    public Documentary getDocumentary() {
        return new PixarDocumentary();
    }

    @Override
    public Historical getHistorical() {
        return new PixarHistorical();
    }
}
class BlueSkyFactory implements AbstractFactory {
    @Override
    public Comedy getComedy() {
        return new BlueSkyComedy();
    }

    @Override
    public Documentary getDocumentary() {
        return new BlueSkyDocumentary();
    }

    @Override
    public Historical getHistorical() {
        return new BlueSkyHistorical();
    }
}
public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractFactory pixarFactory = new PixarFactory();
        Comedy pixarComedy = pixarFactory.getComedy();
        Documentary pixarDocumentary = pixarFactory.getDocumentary();
        Historical pixarHistorical = pixarFactory.getHistorical();

        System.out.println(pixarComedy.getName());
        System.out.println(pixarDocumentary.getName());
        System.out.println(pixarHistorical.getName());

        AbstractFactory blueSkyFactory = new BlueSkyFactory();
        Comedy blueSkyComedy = blueSkyFactory.getComedy();
        Documentary blueSkyDocumentary = blueSkyFactory.getDocumentary();
        Historical blueSkyHistorical = blueSkyFactory.getHistorical();

        System.out.println(blueSkyComedy.getName());
        System.out.println(blueSkyDocumentary.getName());
        System.out.println(blueSkyHistorical.getName());
    }
}