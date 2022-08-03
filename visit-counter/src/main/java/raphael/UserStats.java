package raphael;

import java.util.Optional;

public class UserStats {

    Optional<Long> visitCount = Optional.empty();

    public UserStats(Long visitCount) {
        this.visitCount = Optional.of(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
