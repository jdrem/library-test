package net.remgant.library;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
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

//        builder.put("results",listBuilder.build());
//        return builder.build();
        return listBuilder.build();
    }


}
