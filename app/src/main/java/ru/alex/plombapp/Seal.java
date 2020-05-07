package ru.alex.plombapp;

class Seal {
    final String sealType;
    final String previousType;
    final String sealNumber;
    final int previousNumber;
    final String sealPlacement;
    final String previousPlacement;

    Seal(String sealType, String previousType, String sealNumber, int previousNumber, String sealPlacement, String previousPlacement) {
        this.sealType = sealType;
        this.previousType = previousType;
        this.sealNumber = sealNumber;
        this.previousNumber = previousNumber;
        this.sealPlacement = sealPlacement;
        this.previousPlacement = previousPlacement;
    }
}
