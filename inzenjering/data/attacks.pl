% Excavation
risk(excavation,high,77).
severity(excavation,medium,77).
scope(excavation,confidentiality,22).
impact(excavation,read-data,59).
prerequisites(excavation,interaction-with-the-system,55).
mitigations(excavation,minimize-response-output,11).
mitigations(excavation,remove-potentially-sensitive-information,88).

% Collect Data from Common Resource Locations
severity(collect-data-from-common-resource-locations,medium,65).       
prerequisites(collect-data-from-common-resource-locations,knowledge-of-file-location,12).

% Query System for Information
risk(query-system-for-information,high,68).
severity(query-system-for-information,low,38).
scope(query-system-for-information,confidentiality,55).
impact(query-system-for-information,read-data,28).
skills(query-system-for-information,knowledge-of-the-target-platform,44).
skills(query-system-for-information,knowledge-languages,33).
skills(query-system-for-information,knowledge-package,25).
skills(query-system-for-information,knowledge-software-design,68).
prerequisites(query-system-for-information,test-hypotheses,25).	
prerequisites(query-system-for-information,interaction-with-the-application,85). 
mitigations(query-system-for-information,construct-a-code-book-for-error-messages,85).
mitigations(query-system-for-information,wrap-application-functionality-in-an-output-encoding-scheme,85).

% Directory Indexing
risk(directory-indexing,high,26).
severity(directory-indexing,medium,35).
impact(directory-indexing,read-data,45).
scope(directory-indexing,confidentiality,22).
skills(directory-indexing,to-issue-the-request-to-URL-without-given-a-specific-file-name,25).
skills(directory-indexing,to-bypass-the-access-control-of-the-directory-of-listings,33).	    
prerequisites(directory-indexing,the-target-must-be-misconfigured,12).
prerequisites(directory-indexing,control-the-path,22).
prerequisites(directory-indexing,the-administrator-must-have-failed-to-properly-configure-an-ACL,55).
prerequisites(directory-indexing,the-server-version-must-not-prevent-known-directory-listing-attacks-from-working,11).
mitigations(directory-indexing,using-blank-index-html,22).
mitigations(directory-indexing,preventing-with-htaccess-in-apache-web-server,52).
mitigations(directory-indexing,suppressing-error-messages,32).

% Fuzzing for application mapping
risk(fuzzing-for-application,high,85).
severity(fuzzing-for-application,low,85).
impact(fuzzing-for-application,confidentiality-information-leakage,59).
scope(fuzzing-for-application,confidentiality,33).
skills(fuzzing-for-application,knowledge-of-the-target-platform,44).
skills(fuzzing-for-application,knowledge-languages,33).
skills(fuzzing-for-application,knowledge-package,25).
skills(fuzzing-for-application,knowledge-software-design,68).
prerequisites(fuzzing-for-application,the-target-application-must-fail-to-sanitize-incoming-messages ,85).
mitigations(fuzzing-for-application,construct-a-code-book-for-error-messages,22).
mitigations(fuzzing-for-application,wrap-application-functionality-in-an-output-encoding-scheme,51).
mitigations(fuzzing-for-application,obfuscate-server-fields-of-HTTP-response,18).
mitigations(fuzzing-for-application,hide-inner-ordering-of-HTTP-response-header,18).
mitigations(fuzzing-for-application,customizing-HTTP-error-codes-such-as-404-or-500,38).
mitigations(fuzzing-for-application,hide-HTTP-response-header-software-information-filed,34).
mitigations(fuzzing-for-application,hide-cookies-software-information-filed,28).
mitigations(fuzzing-for-application,obfuscate-database-type-in-database-APIs-error-message,55).

% Fuzzing for garnering other adjacent user/sensitive data
severity(fuzzing-for-garnering-other-adjacent-user-sensitive-data,medium,45).
prerequisites(fuzzing-for-garnering-other-adjacent-user-sensitive-data,the-server-process-queries-without-adequately-checking,80).

% Cross-Domain Search Timing
severity(cross-domain-search-timing,medium,85).
impact(cross-domain-search-timing,read-data,59).
scope(cross-domain-search-timing,confidentiality,33).
skills(cross-domain-search-timing,some-knowledge-of-java-script,78).
prerequisites(cross-domain-search-timing,ability-to-issue-get-or-post-requests ,85).
mitigations(cross-domain-search-timing,cross-site-request-forgery-protection,85).
mitigations(cross-domain-search-timing,the-browsers-security-not-leak-timing-information-for-cross-domain-requests,85).

% WSDL Scanning
risk(WSDL-scanning,high,85).
severity(WSDL-scanning,high,85).
impact(WSDL-scanning,read-data,59).
scope(WSDL-scanning,confidentiality,33).
skills(WSDL-scanning,perform-more-sophisticated-attacks,78).
prerequisites(WSDL-scanning,program-can-read-the-WSDL ,85).  
prerequisites(WSDL-scanning,within-the-WSDL-interface-are-vulnerable-functions,85).
mitigations(WSDL-scanning,validate-the-received-messages-against-the-WSDL-Schema,85).
mitigations(WSDL-scanning,provide-limited-access-to-WSDL-file,85).
mitigations(WSDL-scanning,ensure-the-WSDL-does-not-expose-functions-and-APIs ,85).
mitigations(WSDL-scanning,do-not-give-an-easily-guessed-function-name,85).

% Pull Data from System Resources
impact(pull-data-from-system-resources,pull-data,53).

% Probe Application Memory
risk(probe-application-memory,low,55).
severity(probe-application-memory,medium,63).   
impact(probe-application-memory,read-data,74).
scope(probe-application-memory,confidentiality,35).
skills(probe-application-memory,the-ability-to-traverse-directory-structure,45).                        
prerequisites(probe-application-memory,ability-to-interact-with-the-system,48).
prerequisites(probe-application-memory,the-cloud-provider-must-not-delete-sensitive-data-or-which-they-are-responsible,48).
mitigations(probe-application-memory,deletion-of-data,55).

% Reverse Engineering
risk(reverse-engineering,low,85).
severity(reverse-engineering,low,85).
skills(reverse-engineering,understanding-of-low-level-programming-languages-or-technologies,78).
skills(reverse-engineering,understanding-networking-protocols,78).
prerequisites(reverse-engineering,access-to-targeted-system-resources-and-information,85).
mitigations(reverse-engineering,employ-code-obfuscation-techniques,85).

% White Box Reverse Engineering
severity(white-box-reverse-engineering,medium,45).
prerequisites(white-box-reverse-engineering,direct-access-to-the-object-or-software,55).

% Lifting Sensitive Data Embedded in Cache
severity(lifting-sensitive-data-embedded-in-cache,medium,85).
impact(lifting-sensitive-data-embedded-in-cache,disclosure-of-sensitive-information,85).
prerequisites(lifting-sensitive-data-embedded-in-cache,sensitive-information-must-store-in-a-cache,85).
prerequisites(lifting-sensitive-data-embedded-in-cache,the-cache-must-be-inadequately-protected-against-attacker-access,85).
mitigations(lifting-sensitive-data-embedded-in-cache,strong-encryption-schemes,85).

% Retrieve Embedded Sensitive Data
risk(retrieve-embedded-sensitive-data,high,88).
severity(retrieve-embedded-sensitive-data,very-high,91).
scope(retrieve-embedded-sensitive-data,confidentiality,12).
scope(retrieve-embedded-sensitive-data,integrity,55).
scope(retrieve-embedded-sensitive-data,access-control,35).
scope(retrieve-embedded-sensitive-data,authorization,66).
impact(retrieve-embedded-sensitive-data,read-data,54).
impact(retrieve-embedded-sensitive-data,modify-data,45).
impact(retrieve-embedded-sensitive-data,access-control,12).
skills(retrieve-embedded-sensitive-data,knowledge-of-client-code-structure,45).
skills(retrieve-embedded-sensitive-data,ability-to-reverse-engineer-or-decompile-code,71).
prerequisites(retrieve-embedded-sensitive-data,some-valuable-data-must-be-present-in-client-software,20).
prerequisites(retrieve-embedded-sensitive-data,information-must-be-unprotected-or-protected-in-a-flawed-fashion,15).

% Black Box Reverse Engineering
risk(black-box-reverse-engineering,low,85).
consequences(black-box-reverse-engineering,discover-the-structure-function-and-composition-of-a-type-of-computer-software,85).

% Analysis of Packet Timing and Sizes
severity(analysis-of-packet-timing-and-sizes,low,44).
scope(analysis-of-packet-timing-and-sizes,confidentiality,12).
impact(analysis-of-packet-timing-and-sizes,read-date,77).
skills(analysis-of-packet-timing-and-sizes,sophisticated-machine-learning-techniques,30).
prerequisites(analysis-of-packet-timing-and-sizes,use-of-untrusted-communication-paths,74).
mitigations(analysis-of-packet-timing-and-sizes,distort-packet-sizes-and-timing-at-VPN-layer-by-adding-padding-to-normalize-packet-sizes-and-timing-delays,11).

% Electromagnetic Side-Channel Attack
severity(electromagnetic-side-channel-attack,low,85).
impact(electromagnetic-side-channel-attack,read-data,85).
scope(electromagnetic-side-channel-attack,confidentiality,12).
impact(electromagnetic-side-channel-attack,decrypt-VOIP-communications,85).
impact(electromagnetic-side-channel-attack,access-the-enterprise-VPN-server,85).
skills(electromagnetic-side-channel-attack,sophisticated-attack,85).
prerequisites(electromagnetic-side-channel-attack,proximal-access-to-the-device,85).
mitigations(electromagnetic-side-channel-attack,utilize-side-channel-resistant-implementations-of-all-crypto-algorithms ,85).
mitigations(electromagnetic-side-channel-attack,strong-physical-security-of-all-devices-that-contain-secret-key-information,85).

% Compromising Emanations Attack
severity(compromising-emanations-attack,low,85).
scope(compromising-emanations-attack,confidentiality,12).
impact(compromising-emanations-attack,read-data,85).
skills(compromising-emanations-attack,sophisticated-attack,85).
prerequisites(electromagnetic-side-channel-attack,proximal-access-to-the-device,85).

% Protocol Analysis
risk(protocol-analysis,low,12).
severity(protocol-analysis,low,15).
scope(protocol-analysis,confidentiality,12).
scope(protocol-analysis,integrity,55).
impact(protocol-analysis,read-data,32).
impact(protocol-analysis,modify-data,29).
skills(protocol-analysis,knowledge-of-the-open-systems-interconnection-model,42).
skills(protocol-analysis,familiarity-with-wireshark,26).
prerequisites(protocol-analysis,access-to-a-binary-executable,42).
prerequisites(protocol-analysis,the-ability-to-observe-and-interact-with-a-communication-channel-between-communicating-processes,33).

% Cryptanalysis
risk(cryptanalysis,low,85).
severity(cryptanalysis,very-high,85).
scope(cryptanalysis,confidentiality,12).
impact(cryptanalysis,read-data,85).
skills(cryptanalysis,significant-level-of-understanding-of-mathematics-and-computation,85).
prerequisites(cryptanalysis,some-sort-of-cryptographic-algorithm,85).
prerequisites(cryptanalysis,access-to-the-ciphertext,85).
prerequisites(cryptanalysis,the-encryption-algorithm,63).
prerequisites(cryptanalysis,underlying-weaknesses,85).
mitigations(cryptanalysis,algorithms-are-used-correctly,85).
mitigations(cryptanalysis,use-proven-cryptographic-algorithms,85).

% Leveraging Race Conditions 
risk(leveraging-race-conditions,high,87).
severity(leveraging-race-conditions,high,87).
scope(leveraging-race-conditions,confidentiality,55).
scope(leveraging-race-conditions,access-control,66).
scope(leveraging-race-conditions,authorization,54).
scope(leveraging-race-conditions,integrity,32).
impact(leveraging-race-conditions,gain-privileges,64).
impact(leveraging-race-conditions,modify-data,91).
skills(leveraging-race-conditions,basic-knowledge-of-concurrent-processing,67).
prerequisites(leveraging-race-conditions,resource-accessed-or-modified-concurrently,84).
mitigations(leveraging-race-conditions,use-synchronization,43).
mitigations(leveraging-race-conditions,use-safe-libraries,66).

% Manipulating State
risk(manipulating-state,medium,54).
severity(manipulating-state,high,78).
scope(manipulating-state,confidentiality,25).
scope(manipulating-state,access-control,56).
scope(manipulating-state,authorization,34).
scope(manipulating-state,integrity,62).
scope(manipulating-state,availability,64).
impact(manipulating-state,gain-privileges,33).
impact(manipulating-state,modify-data,61).
impact(manipulating-state,unreliable-execution,62).
skills(manipulating-state,knowledge-of-state-management,37).
skills(manipulating-state,ability-to-manipulate-the-state,71).
mitigations(manipulating-state,avoid-sensitive-information-in-use-controllable-locations,77).
mitigations(manipulating-state,protect-sensitive-information,35).

% Shared Resource Manipulation
severity(shared-resource-manipulation,medium,56).
prerequisites(shared-resource-manipulation,ability-to-compromise-one-of-the-sharing-applications,44).

% Mobile Device Fault Injection
scope(mobile-device-fault-injection,confidentiality,66).
scope(mobile-device-fault-injection,access-control,43).
impact(mobile-device-fault-injection,read-data,78).
skills(mobile-device-fault-injection,skills-to-create/implement-fault-injection-attack-on-mobile-devices,43).
mitigations(mobile-device-fault-injection,strong-physical-security-for-devices-holding-key, 67).
mitigations(mobile-device-fault-injection,frequent-changes-to-keys,47).
mitigations(mobile-device-fault-injection,frequent-changes-to-certificates,33).

% Interface Manipulation
risk(interface-manipulation,medium,55).
severity(interface-manipulation,medium,60).
impact(interface-manipulation,execute-functionality-not-intended-by-the-interface,71).
prerequisites(interface-manipulation,system-must-expose-interface-functionality,45).

% Exploit Non-Production Interfaces
risk(exploit-non-production-interfaces,low,11).
severity(exploit-non-production-interfaces,high,47).
scope(exploit-non-production-interfaces,confidentiality,17).
scope(exploit-non-production-interfaces,access-control,63).
scope(exploit-non-production-interfaces,authentication,87).
impact(exploit-non-production-interfaces,gain-privileges,64).
impact(exploit-non-production-interfaces,bypass-protection,79).
skills(exploit-non-production-interfaces,knowledge-about-the-potential-non-production-interfaces-left-enabled,91).
prerequisites(exploit-non-production-interfaces,configured-non-production-interfaces-and-failed-to-secure,86).
mitigations(exploit-non-production-interfaces,ensure-that-production-systems-do-not-contain-non-production-interfaces,93).
mitigations(exploit-non-production-interfaces,non-production-interfaces-are-only-used-in-development-environments,81).

% Root/Jailbreak Detection Evasion via Debugging
risk(root/jailbreak-detection-evasion-via-debugging,medium,42).
severity(root/jailbreak-detection-evasion-via-debugging,very-high,89).
scope(root/jailbreak-detection-evasion-via-debugging,integrity,65).
scope(root/jailbreak-detection-evasion-via-debugging,authorization,75).
impact(root/jailbreak-detection-evasion-via-debugging,excute-unauthorized-commands,73).
skills(root/jailbreak-detection-evasion-via-debugging,knowledge-about-root/jailbreak-detection,92).
skills(root/jailbreak-detection-evasion-via-debugging,knowledge-about-runtime-debugging,81).
% prerequisites(root/jailbreak-detection-evasion-via-debugging,a-debugger-must-be-able-to-be-inserted-into-the-targeted-application,69).
mitigations(root/jailbreak-detection-evasion-via-debugging,ensure-that-debuggers-are-not-attached,77).

% Functionality Misuse
risk(functionality-misuse,medium,22).
severity(functionality-misuse,medium,42).
scope(functionality-misuse,confidentiality,19).
impact(functionality-misuse,gain-privileges,31).
skills(functionality-misuse,knowledge-about-how-applications-are-launched-and-configured,28).
prerequisites(functionality-misuse,the-adversary-has-the-capability-to-interact-with-the-application-directly,43).
% mitigations(functionality-misuse,perform-comprehensive-threat-modeling-a-process-of-identifying-evaluating-and-mitigating-potential-threats-to-the-application,71).

% Content Spoofing
risk(content-spoofing,medium,21).
severity(content-spoofing,medium,7).
scope(content-spoofing,integrity,12).
impact(content-spoofing,modify-data,24).
% prerequisites(content-spoofing,the-adversary-must-have-the-means-to-alter-data-to-which-they-are-not-authorized,29).

%lista preduslova za unijeti napad 
prerequisite(A,L) :- findall(P,prerequisites(A,P,V),L).

%lista preduslova za unijeti napad sortirana po vjerovatnoci 
prerequisites_sorted(A,L) :- findall([V,P],prerequisites(A,P,V),L1),sort(L1,L).

%lista potrebnih vjestina za unijeti napad 
skill(A,L) :- findall(S,skills(A,S,V),L).

%lista mjera zastite za unijeti napad 
mitigation(A,L) :- findall(M,mitigations(A,M,V),L).

%lista svih napada koji imaju isti risk 
attack(R,L) :- findall(A,risk(A,R,V),L).

%lista napada za unijeti severity 
attack1(S,L) :- findall(A,severity(A,S,V),L).

%lista napada za unijeti severity sortirana po vjerovatnoci rastuce
attack_sorted(S,L) :- findall([V,A],severity(A,S,V),L1),sort(L1,L).


%lista napada za unijeti severity sortirana po vjerovatnoci opadajuce
attack_sorted(S,L) :- findall([V,A],severity(A,S,V),L1),sort(0,@>,L1,L).










