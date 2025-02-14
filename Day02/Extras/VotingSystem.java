import java.util.*;
import java.util.stream.Collectors;
class Candidate {
    private final String name;
    private final String party;
    private final int candidateId;

    public Candidate(String name, String party, int candidateId) {
        this.name = name;
        this.party = party;
        this.candidateId = candidateId;
    }

    // Getters
    public String getName() { return name; }
    public String getParty() { return party; }
    public int getCandidateId() { return candidateId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return candidateId == candidate.candidateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, party);
    }
}

class VotingSystem {
    private Map<Candidate, Integer> voteMap;
    private Map<Candidate, Integer> votesInOrder;
    private TreeMap<Integer, List<Candidate>> sortedVotes;
    private int totalVotes;

    public VotingSystem() {
        this.voteMap = new HashMap<>();
        this.votesInOrder = new LinkedHashMap<>();
        this.sortedVotes = new TreeMap<>(Collections.reverseOrder());
        this.totalVotes = 0;
    }

    public void castVote(Candidate candidate) {
        int currentVotes = voteMap.getOrDefault(candidate, 0);
        voteMap.put(candidate, currentVotes + 1);
        votesInOrder.put(candidate, currentVotes + 1);
        updateSortedVotes(candidate, currentVotes, currentVotes + 1);
        totalVotes++;
    }

    private void updateSortedVotes(Candidate candidate, int oldCount, int newCount) {
        if (oldCount > 0 && sortedVotes.containsKey(oldCount)) {
            sortedVotes.get(oldCount).remove(candidate);
            if (sortedVotes.get(oldCount).isEmpty()) {
                sortedVotes.remove(oldCount);
            }
        }
        sortedVotes.computeIfAbsent(newCount, k -> new ArrayList<>()).add(candidate);
    }

    public List<Map.Entry<Candidate, Integer>> getSortedResults() {
        return sortedVotes.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(candidate -> Map.entry(candidate, entry.getKey())))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<Candidate, Integer>> getResultsInVotingOrder() {
        return new ArrayList<>(votesInOrder.entrySet());
    }

    public int getVoteCount(Candidate candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }

    public List<Candidate> getWinningCandidates() {
        return sortedVotes.isEmpty() ? Collections.emptyList() : new ArrayList<>(sortedVotes.firstEntry().getValue());
    }

    public double getVotePercentage(Candidate candidate) {
        return totalVotes == 0 ? 0.0 : (getVoteCount(candidate) * 100.0) / totalVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        Candidate candidate1 = new Candidate("Mohit Soni", "Party A", 1);
        Candidate candidate2 = new Candidate("Kapil Namdev", "Party B", 2);
        Candidate candidate3 = new Candidate("Vidhi Jain", "Party C", 3);

        for (int i = 0; i < 5; i++) votingSystem.castVote(candidate1);
        for (int i = 0; i < 3; i++) votingSystem.castVote(candidate2);
        for (int i = 0; i < 4; i++) votingSystem.castVote(candidate3);

        System.out.println("Election Results (Sorted by votes):");
        votingSystem.getSortedResults().forEach(entry -> 
            System.out.printf("%s: %d votes (%.1f%%)\n", 
                entry.getKey(), 
                entry.getValue(),
                votingSystem.getVotePercentage(entry.getKey())));

        System.out.println("\nWinning Candidate(s):");
        votingSystem.getWinningCandidates().forEach(System.out::println);

        System.out.println("\nTotal votes cast: " + votingSystem.getTotalVotes());
    }
}
