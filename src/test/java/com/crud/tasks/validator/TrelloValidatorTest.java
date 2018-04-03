package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloList testList1 = new TrelloList("1", "Test List np. 1", false);
        TrelloList testList2 = new TrelloList("2", "Test List no. 2", true);
        TrelloList testList3 = new TrelloList("3", "Test List no. 3", false);

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(testList1);
        trelloList.add(testList2);
        trelloList.add(testList3);

        TrelloBoard trelloBoard = new TrelloBoard("1", "Test", trelloList);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoard> fillteredTrelloBoard = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, fillteredTrelloBoard.size());
    }
}