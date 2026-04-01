class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, PriorityQueue<WebsiteVisit>> userToOrderedWebsites = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            String usernameForVisit = username[i];
            Integer timestampForVisit = timestamp[i];
            String websiteForVisit = website[i];

            WebsiteVisit singleVisit = new WebsiteVisit(websiteForVisit, timestampForVisit);
            PriorityQueue<WebsiteVisit> userVisits = userToOrderedWebsites.getOrDefault(usernameForVisit, new PriorityQueue<>(Comparator.comparing(a -> a.timestamp)));
            userVisits.add(singleVisit);
            userToOrderedWebsites.put(usernameForVisit, userVisits);
        }

        HashMap<Queue<String>, Integer> patternCount = new HashMap<>();

        for (String key : userToOrderedWebsites.keySet()) {
            HashSet<Queue<String>> userPatterns = new HashSet<>();
            PriorityQueue<WebsiteVisit> userVisits = userToOrderedWebsites.get(key);
            if (userVisits.size() < 3) {
                continue;
            }
            Queue<String> pattern = new LinkedList<>();
            pattern.add(userVisits.poll().website);
            pattern.add(userVisits.poll().website);
            pattern.add(userVisits.poll().website);
            userPatterns.add(new LinkedList<>(pattern));

            while (!userVisits.isEmpty()) {
                WebsiteVisit singleVisit = userVisits.poll();

                pattern.poll();
                pattern.add(singleVisit.website);

                userPatterns.add(new LinkedList<>(pattern));
            }
            for (Queue<String> singlePattern : userPatterns) {
                Integer singleCount = patternCount.getOrDefault(singlePattern, 0);
                singleCount++;
                patternCount.put(singlePattern, singleCount);
            }
        }
        List<String> maxPattern = new ArrayList<>();
        Integer maxCount = 0;
        for (Queue<String> key : patternCount.keySet()) {
            Integer count = patternCount.get(key);
            if (count > maxCount) {
                maxPattern = new ArrayList(key);
                maxCount = count;
            }
            if (count == maxCount) {
                maxPattern = getFirstLexicographicSubArray(maxPattern, new ArrayList(key));
            }
        }
        System.out.println(maxCount);
        return maxPattern;
    }

    public List<String> getFirstLexicographicSubArray(List<String> queue1, List<String> queue2) {
        for (int i = 0; i < queue1.size(); i++) {
            String firstString = queue1.get(i);
            String secondString = queue2.get(i);
            if (firstString.compareTo(secondString) < 0) {
                return queue1;
            }
            if (secondString.compareTo(firstString) < 0) {
                return queue2;
            }
        }
        return queue2;
    }
}

class WebsiteVisit {
    String website;
    Integer timestamp;

    public WebsiteVisit(String website, Integer timestamp) {
        this.website = website;
        this.timestamp = timestamp;
    }
}