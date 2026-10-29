/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peldateszt;

import blackjack.model.*;
import minijunit.*;
/**
 *
 * @author ministar
 */
public class HandTeszt {
    
    private Hand hand;
    
    private Card card(Rank rank, Suit suit)
    {
        return new Card(rank, suit);
    }
    
    @Elotte
    public void setUp() {
        hand = new Hand();
    }

    @Teszt
    public void emptyHandValueIsZero() {
        Assert.egyenlo(0, hand.getValue());
    }

    @Teszt
    public void addCardIncreasesSize() {
        hand.addCard(card(Rank.FIVE, Suit.HEARTS));
        Assert.egyenlo(1, hand.getCards().size());
    }

    @Teszt
    public void aceCountsAsEleven() {
        hand.addCard(card(Rank.ACE, Suit.SPADES));
        hand.addCard(card(Rank.NINE, Suit.HEARTS));
        Assert.egyenlo(20, hand.getValue());
    }

    @Teszt
    public void aceCountsAsOneWhenBust() {
        hand.addCard(card(Rank.ACE, Suit.SPADES));
        hand.addCard(card(Rank.NINE, Suit.HEARTS));
        hand.addCard(card(Rank.FIVE, Suit.CLUBS));
        Assert.egyenlo(15, hand.getValue());
    }

    @Teszt
    public void bustOverTwentyOne() {
        hand.addCard(card(Rank.KING, Suit.SPADES));
        hand.addCard(card(Rank.QUEEN, Suit.HEARTS));
        hand.addCard(card(Rank.TWO, Suit.CLUBS));
        Assert.igaz(hand.isBust());
    }

    @Teszt
    public void blackjackWithAceAndKing() {
        hand.addCard(card(Rank.ACE, Suit.SPADES));
        hand.addCard(card(Rank.KING, Suit.HEARTS));
        Assert.igaz(hand.isBlackjack());
    }

    @Teszt
    public void threeCardTwentyOneIsNotBlackjack() {
        hand.addCard(card(Rank.SEVEN, Suit.SPADES));
        hand.addCard(card(Rank.SEVEN, Suit.HEARTS));
        hand.addCard(card(Rank.SEVEN, Suit.CLUBS));
        Assert.hamis(hand.isBlackjack());
    }

    @Teszt
    @VartKivetel(IllegalArgumentException.class)
    public void nullCardIsRejected() {
        hand.addCard(null);
    }

    @Teszt
    public void fromStringToStringRoundTrip() {
        hand.addCard(card(Rank.ACE, Suit.SPADES));
        hand.addCard(card(Rank.KING, Suit.HEARTS));
        String text = hand.toString();
        Hand parsed = Hand.fromString(text);
        Assert.egyenlo(text, parsed.toString());
    }

    // --- intentionally failing tests (required: 2) ---

    @Teszt
    public void INTENTIONAL_FAIL_wrongValue() {
        hand.addCard(card(Rank.KING, Suit.SPADES));
        hand.addCard(card(Rank.FIVE, Suit.HEARTS));
        Assert.egyenlo(16, hand.getValue());
    }

    @Teszt
    public void INTENTIONAL_FAIL_wrongBust() {
        hand.addCard(card(Rank.TEN, Suit.SPADES));
        hand.addCard(card(Rank.FIVE, Suit.HEARTS));
        Assert.igaz(hand.isBust());
    }
}
