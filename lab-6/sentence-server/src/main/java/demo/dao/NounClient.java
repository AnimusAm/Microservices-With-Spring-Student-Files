package demo.dao;

import demo.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static demo.dao.WordDao.NOUN;

@FeignClient(NOUN)
public interface NounClient {

    // Not needed indeed - just as reminder this is GET method
    @RequestMapping(method=RequestMethod.GET)
    Word getWord();
}
