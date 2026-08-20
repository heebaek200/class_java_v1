package http.ch04;


public record User(
        int id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {

    public record Address(
            String street,
            String suite,
            String city,
            String zipcode,
            Geo geo
    ) {
        public record Geo(
                String lat,
                String lng
        ) {
        }
    }

    public record Company(
            String name,
            String catchPhrase,
            String bs
    ) {
    }

    @Override
    public String toString() {
        return """
                        {
                            id : %d,
                            name : %s,
                            username : %s,
                            address : {
                                street : %s,
                                suite : %s,
                                city : %s,
                                zipcode : %s,
                                geo : {
                                    lat : %s,
                                    lng : %s
                                }
                            },
                            phone : %s,
                            website : %s,
                            company : {
                                name : %s,
                                catchPhrase : %s,
                                bs : %s
                            }
                        }
                        """.formatted(
                this.id(),
                this.name(),
                this.username(),
                this.email(),
                this.address().street(),
                this.address().suite(),
                this.address().city(),
                this.address().zipcode(),
                this.address().geo().lat(),
                this.address().geo().lng(),
                this.phone(),
                this.website(),
                this.company().name(),
                this.company().catchPhrase(),
                this.company().bs()
        );
    }
}