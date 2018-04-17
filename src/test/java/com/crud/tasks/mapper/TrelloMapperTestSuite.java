package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
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
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "test mapToCard", "test", "1");

        //When
        String name = trelloCardDto.getName();
        String desc = trelloCardDto.getDescription();
        String pos = trelloCardDto.getPos();
        String listId = trelloCardDto.getListId();

        //Then
        assertEquals("Test", name);
        assertEquals("test mapToCard", desc);
        assertEquals("test", pos);
        assertEquals("1", listId);
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test", "test mapToCard", "test", "1");

        //When
        String name = trelloCard.getName();
        String desc = trelloCard.getDescription();
        String pos = trelloCard.getPos();
        String listId = trelloCard.getListId();

        //Then
        assertEquals("Test", name);
        assertEquals("test mapToCard", desc);
        assertEquals("test", pos);
        assertEquals("1", listId);
    }

    private List<TrelloList> trelloListForTests() {
        TrelloList trelloList1 = new TrelloList("1", "list 1", false);
        TrelloList trelloList2 = new TrelloList("2", "list 2", true);
        TrelloList trelloList3 = new TrelloList("3", "list 3", false);

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(trelloList1);
        trelloList.add(trelloList2);
        trelloList.add(trelloList3);
        return trelloList;
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloLists = trelloListForTests();

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(3, trelloListDto.size());
    }

    private List<TrelloListDto> trelloListDtoForTests() {
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "list 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "list 2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "list 3", false);

        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(trelloListDto1);
        trelloListDto.add(trelloListDto2);
        trelloListDto.add(trelloListDto3);
        return trelloListDto;
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = trelloListDtoForTests();

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals(3, trelloList.size());
    }

    @Test
    public void mapToBoardsTest(){
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "Test", trelloListDtoForTests());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(1, trelloBoardList.size());
        assertEquals("1", trelloBoardList.get(0).getId());
        assertEquals("Test", trelloBoardList.get(0).getName());
    }

    @Test
    public void mapToBoardsDtoTest(){
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("1", "Test", trelloListForTests());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals("1", trelloBoardDtoList.get(0).getId());
        assertEquals("Test", trelloBoardDtoList.get(0).getName());
    }
}
