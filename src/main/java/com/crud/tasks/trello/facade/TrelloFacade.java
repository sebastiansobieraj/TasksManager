package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);

    @Autowired
    private TrelloService trelloService;

    @Autowired
    private TrelloMapper trelloMapper;

    @Autowired
    TrelloValidator trelloValidator;

    public List<TrelloBoardDto> fetchTrelloBoards(){
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloService.fetchTrelloBoards());

        LOGGER.info("Starting filtering boards...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Boards has been filtered. Current list size: " + filteredBoards.size());

        return trelloMapper.mapToBoardsDto(filteredBoards);
    }

    public CreatedTrelloCardDto createCard(final TrelloCardDto trelloCardDto){
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        if(trelloCard.getName().contains("test")) {
            LOGGER.info("Someone is testing my application!");
        } else {
            LOGGER.info("Seems that my application is used in proper way.");
        }
        return trelloService.createdTrelloCard(trelloMapper.mapToCardDto(trelloCard));
    }
}
