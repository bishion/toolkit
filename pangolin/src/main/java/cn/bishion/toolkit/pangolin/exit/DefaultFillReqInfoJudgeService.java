package cn.bishion.toolkit.pangolin.exit;

import feign.RequestTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: guofangbi
 * @date: 2022/5/28-15:42
 * @version: 1.0.0
 */
@Service
public class DefaultFillReqInfoJudgeService implements FillReqInfoJudgeService {
    @Override
    public boolean secureToSetReqInfo(RequestTemplate requestTemplate) {
        return true;
    }
}
