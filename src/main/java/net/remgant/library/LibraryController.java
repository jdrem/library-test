package net.remgant.library;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final static Logger log = LoggerFactory.getLogger(LibraryController.class);

    @RequestMapping(value = "/search", params = {"topic"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> search(@RequestParam(value = "topic") String searchTopic) {
        log.info("got search request: {}",searchTopic);
        ImmutableMap.Builder<String,Object> builder = ImmutableMap.builder();
        ImmutableList.Builder<Map<String,Object>> listBuilder = ImmutableList.builder();
        listBuilder.add(ImmutableMap.of("type","subject","topic","England -- History","url","subject/1","count",2));
        listBuilder.add(ImmutableMap.of("type","subject","topic","England -- Geography","url","subject/2","count",3));
        listBuilder.add(ImmutableMap.of("type","subject","topic","England -- Fiction","url","subject/3","count",5));
        listBuilder.add(ImmutableMap.of("type","creator","topic","England, Joseph","url","creator/6","count",1));
        return listBuilder.build();
    }


    @RequestMapping(value="/subject/{subjectId}", method = RequestMethod.GET)
    @ResponseBody List<Map<String,Object>> subject(@PathVariable("subjectId") int subjectId) {
        log.info("got subject request: {}",subjectId);
        ImmutableList.Builder<Map<String,Object>> listBuilder = ImmutableList.builder();
        listBuilder.add(ImmutableMap.of("title","Wind in the Willows, The", "author","Grahame, Kenneth","url","book/22"));
        listBuilder.add(ImmutableMap.of("title","Persuasion", "author","Austen, Jane","url","book/44"));
        return listBuilder.build();
    }

    @RequestMapping(value="/creator/{creatorId}", method = RequestMethod.GET)
    @ResponseBody List<Map<String,Object>> creator(@PathVariable("creatorId") int creatorId) {
        log.info("got creator request: {}",creatorId);
        ImmutableList.Builder<Map<String,Object>> listBuilder = ImmutableList.builder();
        listBuilder.add(ImmutableMap.of("title","Wind in the Willows, The", "author","Grahame, Kenneth","url","book/22"));
        listBuilder.add(ImmutableMap.of("title","Persuasion", "author","Austen, Jane","url","book/44"));
        return listBuilder.build();
    }

    @RequestMapping(value="/book/{bookId}", method = RequestMethod.GET)
        @ResponseBody Map<String,Object> book(@PathVariable("bookId") int bookId) {
            log.info("got book id request: {}",bookId);
            ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
            builder.put("title","Wind in the Willows, The");
            builder.put("creator","Graham, Kenneth");
            builder.put("subject","England -- Fiction");
            builder.put("lcc","PZ10.3.G76 Wi2");
            builder.put("ddc","Fiction - Grahame");
            return builder.build();
        }
}
